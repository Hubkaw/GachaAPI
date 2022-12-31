package com.gachaapi.Battle;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
public class BattleLog implements Serializable {


    private List<BattleLogEntry> log;
    private Side winner;

    public BattleLog(List<BattleLogEntry> log){
        this.log = log;
        if (log.stream().anyMatch(l -> l.getType() == EntryType.WINNER)) {
            winner = Side.ATTACKER;
        } else {
            winner = Side.DEFENDER;
        }
    }

}
