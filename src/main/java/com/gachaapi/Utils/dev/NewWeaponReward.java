package com.gachaapi.Utils.dev;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NewWeaponReward {
    private int weaponId;
    private int quantity;
    private int dungeonFloorId;
}