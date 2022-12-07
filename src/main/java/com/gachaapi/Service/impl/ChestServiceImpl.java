package com.gachaapi.Service.impl;

import com.gachaapi.Entity.*;
import com.gachaapi.Entity.Character;
import com.gachaapi.Repository.*;
import com.gachaapi.Service.interfaces.ChestService;
import com.gachaapi.Utils.ChestReward;
import com.gachaapi.Utils.PossibleChestReward;
import com.gachaapi.Utils.dev.NewChest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.*;

@Service
@AllArgsConstructor
public class ChestServiceImpl implements ChestService {

    private ChestRepository chestRepository;
    private CollectionRepository collectionRepository;
    private WeaponRepository weaponRepository;
    private PlayerRepository playerRepository;
    private PlayerCharacterRepository playerCharacterRepository;
    private PlayerWeaponRepository playerWeaponRepository;
    private PlayerChestItemRepository playerChestItemRepository;
    private CharacterRepository characterRepository;

    private static final Random random = new Random();

    private static final int HARD_PITY = 15;


    @Override
    public List<Chest> getAll() {
        return chestRepository.findAll();
    }

    @Override
    public void create(NewChest newChest) {
        Chest chest = new Chest();
        chest.setName(newChest.getName());
        chest.setExpiresAt(new Timestamp(newChest.getExpiresAt().getTime()));
        chest.setReleasedAt(new Timestamp(newChest.getReleasedAt().getTime()));
        chest.setCollection(collectionRepository.getReferenceById(newChest.getCollectionId()));
        chest.setPrice(newChest.getPrice());
        chestRepository.save(chest);
    }

    @Override
    public void delete(int id) {
        Chest chest = chestRepository.getReferenceById(id);
        chest.setWeapons(new HashSet<>());
        chest.setCharacters(new HashSet<>());
        chestRepository.delete(chest);
    }

    @Override
    public List<Weapon> getAllWeapons(int chestId) {
        return new ArrayList<>(chestRepository.getReferenceById(chestId).getWeapons());
    }

    @Override
    public void addWeapon(int chestId, int weaponId) {
        Chest chest = chestRepository.getReferenceById(chestId);
        if (chest.getWeapons() == null)
            chest.setWeapons(new HashSet<>());
        chest.getWeapons().add(weaponRepository.getReferenceById(weaponId));
        chestRepository.save(chest);
    }

    @Override
    public void deleteWeapon(int chestId, int weaponId) {
        Chest chest = chestRepository.getReferenceById(chestId);
        chest.getWeapons().removeIf(w -> w.getId() == weaponId);
        chestRepository.save(chest);
    }

    @Override
    public Chest getById(int id) {
        return chestRepository.getReferenceById(id);
    }

    @Override
    public List<Chest> getAvailable() {
        return chestRepository.findAllByExpiresAtIsAfterAndReleasedAtBefore(
                Timestamp.from(Instant.now()), Timestamp.from(Instant.now())
        );
    }

    @Override
    public ChestReward openChest(String nick, int chestId) {

        Player player = playerRepository.findByNick(nick).orElseThrow(() -> new UsernameNotFoundException("AAAAA"));
        Chest chest = chestRepository.getReferenceById(chestId);
        int playerBalance = player.getPlayerBalance();

        if (playerBalance < chest.getPrice())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You dont have enough money ");
        if (!Instant.now().isBefore(chest.getExpiresAt().toInstant()) || !Instant.now().isAfter(chest.getReleasedAt().toInstant()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This chest is unavailable");


        player.setPlayerBalance(playerBalance - chest.getPrice());

        PlayerChestitem pci = new PlayerChestitem();
        pci.setChestByChestIdChest(chest);
        pci.setPlayerByPlayerIdPlayer(player);
        pci.setBoughtAt(Timestamp.from(Instant.now()));
        playerChestItemRepository.save(pci);

        PossibleChestReward reward;
        if (player.getPityRollStatus() >= HARD_PITY) {
            List<PossibleChestReward> possibleChestRewards = new ArrayList<>();
            possibleChestRewards.addAll(chest.getWeapons());
            possibleChestRewards.addAll(chest.getCharacters());
            List<PossibleChestReward> rarestItems = possibleChestRewards.stream().filter(possibleChestReward -> possibleChestReward.getWeight() == 1).toList();
            if (rarestItems.size() > 0)
                reward = rarestItems.get(random.nextInt(rarestItems.size()));
            else
                reward = new RewardGenerator(chest).generate(player.getPityRollStatus());
        } else {
            reward = new RewardGenerator(chest).generate(player.getPityRollStatus());
        }

        if (reward.getWeight() == 1) {
            player.setPityRollStatus(0);
        } else {
            player.incrementPity();
        }
        playerRepository.save(player);

        return addRewardToPlayer(reward, player);

    }

    @Override
    public void addCharacter(int chestId, int characterId) {
        Character character = characterRepository.getReferenceById(characterId);
        Chest chest = chestRepository.getReferenceById(chestId);
        chest.getCharacters().add(character);
        chestRepository.save(chest);
    }

    @Override
    public void deleteCharacter(int chestId, int characterId) {
        Chest chest = chestRepository.getReferenceById(chestId);
        chest.getCharacters().removeIf(c -> c.getId()==characterId);
        chestRepository.save(chest);
    }

    private ChestReward addRewardToPlayer(PossibleChestReward reward, Player player) {
        if (reward instanceof Weapon) {
            PlayerWeapon playerWeapon = new PlayerWeapon();
            System.out.println(playerWeapon.getId());
            playerWeapon.setWeapon((Weapon) reward);
            playerWeapon.setPlayer(player);
            playerWeapon.setAscension(1);
            playerWeapon.setLvl(1);
            playerWeaponRepository.save(playerWeapon);
            return new ChestReward("Weapon", reward);
        }
        if (reward instanceof Character) {
            PlayerCharacter playerCharacter = new PlayerCharacter();
            playerCharacter.setCharacter((Character) reward);
            playerCharacter.setPlayer(player);
            playerCharacter.setAscention(1);
            playerCharacter.setLvl(1);
            playerCharacter.setParties(new HashSet<>());
            playerCharacter.setPlayerArtefacts(new HashSet<>());
            playerCharacter.setPlayerWeapons(new ArrayList<>());
            playerCharacterRepository.save(playerCharacter);
            return new ChestReward("Character", reward);
        }
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "There was a problem with your reward");
    }


    static class RewardGenerator {
        private final NavigableMap<Integer, PossibleChestReward> map = new TreeMap<>();
        private int total;

        public RewardGenerator(Chest chest) {
            if (chest.getCharacters() != null)
                chest.getCharacters().forEach(this::add);
            if (chest.getWeapons() != null)
                chest.getWeapons().forEach(this::add);
        }

        private void add(PossibleChestReward pcr) {
            int weight = pcr.getWeight();
            if (weight <= 0)
                return;
            total += weight;
            map.put(total, pcr);
        }

        public PossibleChestReward generate(int pity) {

            System.out.println(map);
            int rnd = random.nextInt(total) + 1;
            return map.ceilingEntry(rnd).getValue();
        }
    }
}
