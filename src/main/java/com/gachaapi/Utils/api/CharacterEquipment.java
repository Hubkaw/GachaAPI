package com.gachaapi.Utils.api;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CharacterEquipment {
    private int characterId;
    private int glassesId;
    private int ringId;
    private int hatId;
    private int weaponId;
}
