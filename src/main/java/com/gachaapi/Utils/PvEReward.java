package com.gachaapi.Utils;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PvEReward {
    private PvERewardInterface reward;
    private int quantity;
}
