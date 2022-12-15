package com.gachaapi.Utils.dev;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NewArtefactReward {
    private int artefactId;
    private int quantity;
    private int dungeonFloorId;
}
