package com.gachaapi.Utils.dev;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class NewMaterialWeaponClass {
    private int baseAmount;
    private int perLvlAmount;
    private int materialId;
    private int weaponClassId;
}
