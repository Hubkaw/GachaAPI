package com.gachaapi.Service.interfaces;

import com.gachaapi.Entity.Chest;
import com.gachaapi.Entity.Weapon;
import com.gachaapi.Utils.ChestReward;
import com.gachaapi.Utils.dev.NewChest;

import java.util.List;

public interface ChestService {
    List<Chest> getAll();
    void create(NewChest newChest);
    void delete(int id);
    List<Weapon> getAllWeapons(int chestId);
    void addWeapon(int chestId, int weaponId);
    void deleteWeapon(int chestId, int weaponId);
    Chest getById(int id);
    List<Chest> getAvailable();
    ChestReward openChest(String nick, int chestId);
}
