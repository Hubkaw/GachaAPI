package com.gachaapi.Service.interfaces;

import com.gachaapi.Entity.Weapon;
import com.gachaapi.Utils.dev.NewStatWeapon;
import com.gachaapi.Utils.dev.NewWeapon;

import java.util.List;

public interface WeaponService {
    List<Weapon> getAll();
    void create(NewWeapon newWeapon);
    void delete(int id);
    Weapon getById(int id);
    void createStatWeapon(NewStatWeapon newStatWeapon);
    void deleteStatWeapon(int id);
}
