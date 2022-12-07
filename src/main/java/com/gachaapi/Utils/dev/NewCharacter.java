package com.gachaapi.Utils.dev;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NewCharacter {
    private String name;
    private String ability;
    private int affiliationId;
    private int classId;
    private int rarityId;
}
