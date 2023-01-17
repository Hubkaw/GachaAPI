package com.gachaapi.Battle;


import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.AllArgsConstructor;

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
