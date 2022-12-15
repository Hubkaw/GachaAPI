package com.gachaapi.Utils.dev;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NewMaterialReward {
    private int materialId;
    private int quantity;
    private int dungeonFloorId;
}