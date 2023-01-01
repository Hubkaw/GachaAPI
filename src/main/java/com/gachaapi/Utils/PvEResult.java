package com.gachaapi.Utils;

import com.gachaapi.Battle.BattleLog;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class PvEResult {

    private boolean isWinner;
    private int balanceReward;
    private List<PvEReward> rewardList;
    private BattleLog battleLog;

}

