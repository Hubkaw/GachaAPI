package com.gachaapi.Service.impl;

import com.gachaapi.Entity.Chest;
import com.gachaapi.Entity.Weapon;
import com.gachaapi.Repository.ChestRepository;
import com.gachaapi.Repository.CollectionRepository;
import com.gachaapi.Repository.WeaponRepository;
import com.gachaapi.Service.interfaces.ChestService;
import com.gachaapi.Utils.dev.NewChest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ChestServiceImpl implements ChestService {

    private ChestRepository chestRepository;
    private CollectionRepository collectionRepository;
    private WeaponRepository weaponRepository;

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
        chestRepository.save(chest);
    }

    @Override
    public void delete(int id) {
        chestRepository.delete(chestRepository.getReferenceById(id));
    }

    @Override
    public List<Weapon> getAllWeapons(int chestId) {
        return new ArrayList<>(chestRepository.getReferenceById(chestId).getWeapons());
    }

    @Override
    public void addWeapon(int chestId, int weaponId) {
        Chest chest = chestRepository.getReferenceById(chestId);
        if (chest.getWeapons() == null)
            chest.setWeapons(new ArrayList<>());
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


}
