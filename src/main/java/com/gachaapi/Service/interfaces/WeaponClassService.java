package com.gachaapi.Service.interfaces;

import com.gachaapi.Entity.Weaponclass;
import com.gachaapi.Utils.dev.NewMaterialWeaponClass;
import com.gachaapi.Utils.dev.NewWeaponClass;

import java.util.List;

public interface WeaponClassService {
    List<Weaponclass> getAll();
    void create(NewWeaponClass newWeaponClass);
    void delete(int id);
    void addMaterial(NewMaterialWeaponClass newMaterialWeaponClass);
    void deleteMaterial(int id);
    Weaponclass getById(int id);
}
