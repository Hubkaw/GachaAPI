package com.gachaapi.Service.impl;

import com.gachaapi.Battle.Battle;
import com.gachaapi.Battle.BattleLog;
import com.gachaapi.Battle.Side;
import com.gachaapi.Entity.*;
import com.gachaapi.Repository.*;
import com.gachaapi.Service.interfaces.DungeonService;
import com.gachaapi.Utils.BattleType;
import com.gachaapi.Utils.DungeonType;
import com.gachaapi.Utils.PvEResult;
import com.gachaapi.Utils.PvEReward;
import com.gachaapi.Utils.dev.NewDungeon;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import static com.gachaapi.Utils.Constants.DUNGEON_STAMINA_COST;


@Service
@AllArgsConstructor
public class DungeonServiceImpl implements DungeonService {
    private DungeonRepository dungeonRepository;
    private DungeonFloorRepository dungeonFloorRepository;
    private PlayerRepository playerRepository;
    private BattleLogRepository battleLogRepository;
    private PartyRepository partyRepository;
    private PlayerArtefactRepository playerArtefactRepository;
    private PlayerWeaponRepository playerWeaponRepository;
    private PlayerMaterialRepository playerMaterialRepository;


    @Override
    public List<Dungeon> getAll() {
        return dungeonRepository.findAll();
    }

    @Override
    public void create(NewDungeon newDungeon) {
        dungeonRepository.save(newDungeon.create());
    }

    @Override
    public void delete(int id) {
        dungeonRepository.deleteById(id);
    }

    @Override
    public Dungeon getById(int id) {
        return dungeonRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not find this dungeon")
        );
    }

    @Override
    public PvEResult enterDungeon(int floorId, String nickname) {
        Player player = playerRepository.findByNick(nickname).orElseThrow();
        if (player.getActiveParty() < 1) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You have no active party");
        }
        return enterDungeon(floorId, player.getActiveParty(), nickname);
    }

    @Override
    public PvEResult enterDungeon(int floorId, int partyId, String nickname) {
        Party party = partyRepository.findById(partyId).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.BAD_REQUEST, "This party does not exist"));
        if (!party.getPlayer().getNick().equals(nickname)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This party does not belong to you");
        }
        if (party.getCharacters().size() != 4) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This party is invalid");
        }
        Dungeonfloor dungeonfloor = dungeonFloorRepository.findById(floorId).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not find this floor"));
        Player player = playerRepository.findByNick(nickname).orElseThrow();
        if (player.getStamina()<DUNGEON_STAMINA_COST){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You do not have enough stamina to enter.");
        }

        switch (dungeonfloor.getDungeon().getType()) {
            case MAIN:
            case EVENT: {
                if (player.getPlayerDungeonfloors().stream().anyMatch(pdf -> pdf.getDungeonfloor().equals(dungeonfloor))) {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You have already cleared this floor");
                }
            }
            case DAILY: {
                if (player.getPlayerDungeonfloors().stream().anyMatch(pdf ->
                        pdf.getDungeonfloor().equals(dungeonfloor) &&
                                pdf.getClearDate().after(Timestamp.valueOf(LocalDateTime.now().minus(23, ChronoUnit.HOURS))))) {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You can only clear this floor once a day.");
                }
            }
            case WEEKLY: {
                if (player.getPlayerDungeonfloors().stream().anyMatch(pdf ->
                        pdf.getDungeonfloor().equals(dungeonfloor) &&
                                pdf.getClearDate().after(Timestamp.valueOf(LocalDateTime.now().minus(7, ChronoUnit.DAYS))))) {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You can only clear this floor once every 7 days.");
                }
            }
            default: {
                // Jakieś ewentualne inne dungeony ale to już do dodania wedle uznania
            }
        }


        BattleLog log = Battle.simulate(party, dungeonfloor.getParty());
        Side winner = log.getWinner();
        player.setStamina(player.getStamina()-DUNGEON_STAMINA_COST);

        if (winner != Side.ATTACKER) {
            playerRepository.save(player);
            return new PvEResult(false, 0, new ArrayList<>(), log);
        }

        PvEResult result = new PvEResult(true, dungeonfloor.getBalanceReward(), new ArrayList<>(), log);

        for (ArtefactReward ar : dungeonfloor.getArtefactRewards()) {
            result.getRewardList().add(new PvEReward(ar.getArtefact(), ar.getQuantity()));
            PlayerArtefact pa = new PlayerArtefact();
            pa.setArtefact(ar.getArtefact());
            pa.setLvl(1);
            pa.setPlayer(player);
            playerArtefactRepository.save(pa);
        }

        for (MaterialReward mr : dungeonfloor.getMaterialRewards()) {
            result.getRewardList().add(new PvEReward(mr.getMaterial(), mr.getQuantity()));
            PlayerMaterial playerMaterial = player.getPlayerMaterials().stream()
                    .filter(pm -> pm.getMaterial().equals(mr.getMaterial()))
                    .findFirst()
                    .orElse(null);
            if (playerMaterial == null) {
                playerMaterial = new PlayerMaterial();
                playerMaterial.setMaterial(mr.getMaterial());
                playerMaterial.setAmount(mr.getQuantity());
                playerMaterial.setPlayer(player);
            } else {
                playerMaterial.setAmount(playerMaterial.getAmount() + mr.getQuantity());
            }
            playerMaterialRepository.save(playerMaterial);
        }

        for (WeaponReward wr : dungeonfloor.getWeaponRewards()) {
            result.getRewardList().add(new PvEReward(wr.getWeapon(), wr.getQuantity()));
            PlayerWeapon playerWeapon = new PlayerWeapon();
            playerWeapon.setLvl(1);
            playerWeapon.setWeapon(wr.getWeapon());
            playerWeapon.setPlayer(player);
            playerWeaponRepository.save(playerWeapon);
        }

        player.setPlayerBalance(player.getPlayerBalance()+dungeonfloor.getBalanceReward());
        PlayerDungeonfloor pdf = new PlayerDungeonfloor();
        pdf.setPlayer(player);
        pdf.setDungeonfloor(dungeonfloor);
        pdf.setClearDate(Timestamp.from(Instant.now()));
        player.getPlayerDungeonfloors().add(pdf);

        if (dungeonfloor.getDungeon().getType() == DungeonType.MAIN){
            player.setLevel(player.getLevel()+1);
        }

        playerRepository.save(player);

        BattleHistory battleHistory = new BattleHistory();
        battleHistory.setType(BattleType.PvE);
        battleHistory.setLog(log);
        battleHistory.setAttacker(player);
        battleHistory.setDefender(dungeonfloor.getParty().getPlayer());
        battleLogRepository.save(battleHistory);

        return result;
    }

}

