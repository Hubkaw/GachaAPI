package com.gachaapi.Utils;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChestReward {
    private String type;
    private PossibleChestReward drop;
}
