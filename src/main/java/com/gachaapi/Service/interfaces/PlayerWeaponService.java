package com.gachaapi.Service.interfaces;

import com.gachaapi.Entity.Material;
import com.gachaapi.Entity.PlayerArtefact;
import com.gachaapi.Entity.PlayerWeapon;

import java.util.List;
import java.util.Map;

public interface PlayerWeaponService {
    List<PlayerWeapon> getAll(String nickname);
    PlayerWeapon levelUp(int id, String nickname);

    Map<PlayerWeapon, Map<Material, Integer>> getAllWithCost(String nickname);
}
