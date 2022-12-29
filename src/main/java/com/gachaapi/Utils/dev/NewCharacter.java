package com.gachaapi.Utils.dev;

import com.gachaapi.Utils.AbilityType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Optional;

@Data
@AllArgsConstructor
public class NewCharacter {
    private String name;
    private int affiliationId;
    private int classId;
    private int rarityId;
    private String abilityName;
    private AbilityType abilityType;
    private int abilityPotency;
    private Optional<Integer> abilityStatId;
}
