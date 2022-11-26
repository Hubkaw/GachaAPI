package com.gachaapi.Utils.dev;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class NewMaterialAffiliation {
    private int affiliationId;
    private int materialId;
    private int baseAmount;
    private int perLvlAmount;
}
