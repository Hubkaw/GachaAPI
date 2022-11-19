package com.gachaapi.Utils.dev;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class NewWeapon {
    private String name;
    private int elementId;
    private int rarityId;
    private int weaponClassId;
}
