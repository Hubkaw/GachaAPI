package com.gachaapi.Service.impl;

import com.gachaapi.Entity.*;
import com.gachaapi.Repository.*;
import com.gachaapi.Service.interfaces.PlayerService;
import com.gachaapi.Utils.NewPlayer;
import com.gachaapi.Utils.PremiumRewards;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import static com.gachaapi.Utils.Constants.*;

@Service
@AllArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    private PlayerRepository playerRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private PlayerWeaponRepository playerWeaponRepository;
    private PlayerCharacterRepository playerCharacterRepository;
    private CharacterRepository characterRepository;
    private WeaponRepository weaponRepository;
    private PartyRepository partyRepository;
    private MaterialRepository materialRepository;
    private PlayerMaterialRepository playerMaterialRepository;

    @Override
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @Override
    public Player createNewPlayer(NewPlayer newPlayer) {
        Timestamp birthDate = validateNewPlayer(newPlayer);
        if (playerRepository.existsByNick(newPlayer.getNick())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Nickname already used");
        }
        Player player = new Player();
        player.setNick(newPlayer.getNick());
        player.setHashedPassword(passwordEncoder.encode(newPlayer.getPassword()));
        player.setRoles(new HashSet<>());
        player.getRoles().add(roleRepository.findByName(USER_ROLE));
        player.setBirthDate(birthDate);
        player.setEloPoints(1500);
        player.setJoinDate(Timestamp.valueOf(LocalDateTime.now()));
        player.setActiveParty(0);
        player.setPremiumLeft(0);
        player.setStamina(DEFAULT_STAMINA_AMOUNT);
        player.setPityRollStatus(0);
        player.setPremiumCollected(false);
        player.setLevel(1);
        player.setPlayerBalance(2000);

        playerRepository.save(player);

        Party firstParty = createFirstParty(player);
        player.setParties(new HashSet<>());
        player.getParties().add(firstParty);
        player.setActiveParty(firstParty.getId());

        return playerRepository.save(player);
    }

    @Override
    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Player getByName(String nick) {
        return playerRepository.findByNick(nick).orElseThrow(() -> new UsernameNotFoundException("Invalid username"));
    }

    private Timestamp validateNewPlayer(NewPlayer player) {
        if (player.getNick() == null || player.getNick().isBlank() || player.getNick().contains("/") || player.getNick().contains(";") || player.getNick().contains("%") || player.getNick().length() >= 32) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid nickname.");
        }
        if (player.getPassword() == null || player.getPassword().isBlank() || player.getPassword().contains("/") || player.getPassword().contains(";") || player.getPassword().contains("%") || player.getPassword().length() > 64) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid password");
        }
        Timestamp timestamp;
        try {
            timestamp = Timestamp.from(new SimpleDateFormat("yyyy-MM-dd").parse(player.getBirthDate()).toInstant());
        } catch (ParseException parseException) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Incorrect date.");
        }
        if (timestamp.after(Timestamp.valueOf(LocalDateTime.now().minus(13, ChronoUnit.YEARS)))) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You are too young to create an account.");
        }
        return timestamp;
    }

    public Map<String, Integer> getMaterialMap(String nickname) {
        Player player = playerRepository.findByNick(nickname).orElseThrow();
        Map<String, Integer> result = new HashMap<>();
        for (PlayerMaterial pm : player.getPlayerMaterials()) {
            result.put(pm.getMaterial().getName(), pm.getAmount());
        }
        return result;
    }

    @Override
    public PremiumRewards getPremiumRewards(String nick) {
        Player player = playerRepository.findByNick(nick).orElseThrow();
        if (player.getRoles().stream().noneMatch(r -> r.getName().equals(PREMIUM_ROLE))) {
            return null;
        }
        if (player.isPremiumCollected()) {
            return null;
        }

        player.setPlayerBalance(player.getPlayerBalance() + PREMIUM_DAILY_BALANCE_REWARD);
        Map<Material, Integer> rewarded = new HashMap<>();
        materialRepository.findAll().forEach(material -> {
                    rewarded.put(material, PREMIUM_DAILY_MATERIAL_REWARD);
                    PlayerMaterial playerMaterial = player.getPlayerMaterials().stream()
                            .filter(pm -> pm.getMaterial().equals(material))
                            .findFirst()
                            .orElse(null);
                    if (playerMaterial == null) {
                        playerMaterial = new PlayerMaterial();
                        playerMaterial.setMaterial(material);
                        playerMaterial.setAmount(PREMIUM_DAILY_MATERIAL_REWARD);
                        playerMaterial.setPlayer(player);
                    } else {
                        playerMaterial.setAmount(playerMaterial.getAmount() + PREMIUM_DAILY_MATERIAL_REWARD);
                    }
                    playerMaterialRepository.save(playerMaterial);
                }
        );
        player.setPremiumCollected(true);
        playerRepository.saveAndFlush(player);

        return new PremiumRewards(rewarded, PREMIUM_DAILY_BALANCE_REWARD);
    }

    @Override
    public Player buyStaminaForCurrency(int amount, String nick) {
        Player player = playerRepository.findByNick(nick).orElseThrow();
        if (player.getPlayerBalance() < amount) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You cannot afford this");
        }
        player.setPlayerBalance(player.getPlayerBalance() - amount);
        player.setStamina(player.getStamina() + (int) (amount * BALANCE_TO_STAMINA_EXCHANGE_RATIO));
        return playerRepository.save(player);
    }

    private PlayerCharacter createPartyCharacter(Player player, int eqId) {
        PlayerCharacter pc = new PlayerCharacter();
        PlayerWeapon pw = new PlayerWeapon();
        pw.setLvl(2);
        pw.setPlayer(player);
        pw.setWeapon(weaponRepository.getReferenceById(eqId));
        playerWeaponRepository.save(pw);
        pc.setWieldedWeapon(pw);
        pc.setLvl(2);
        pc.setPlayer(player);
        pc.setCharacter(characterRepository.getReferenceById(eqId));
        return playerCharacterRepository.save(pc);
    }

    private Party createFirstParty(Player player){
        Party party = new Party();
        party.setName("First Party");
        party.setPlayer(player);

        HashSet<PlayerCharacter> hashset = new HashSet<>();
        hashset.add(createPartyCharacter(player, 1));
        hashset.add(createPartyCharacter(player, 4));
        hashset.add(createPartyCharacter(player, 8));
        hashset.add(createPartyCharacter(player, 11));
        party.setCharacters(hashset);
        return partyRepository.save(party);
    }
}
