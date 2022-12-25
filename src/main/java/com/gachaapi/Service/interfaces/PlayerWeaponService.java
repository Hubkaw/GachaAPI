package com.gachaapi.Service.interfaces;

import com.gachaapi.Entity.PlayerArtefact;
import com.gachaapi.Entity.PlayerWeapon;

import java.util.List;

public interface PlayerWeaponService {
    List<PlayerWeapon> getAll(String nickname);
    PlayerWeapon levelUp(int id, String nickname);
}
