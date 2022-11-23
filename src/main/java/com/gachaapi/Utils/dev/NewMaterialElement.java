package com.gachaapi.Utils.dev;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class NewMaterialElement {
    private int elementId;
    private int materialId;
    private int baseAmount;
    private int perLvlAmount;

}
