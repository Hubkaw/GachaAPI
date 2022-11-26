package com.gachaapi.Utils.dev;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class NewMaterialClass {
    private int classId;
    private int materialId;
    private int baseAmount;
    private int perLvlAmount;
}
