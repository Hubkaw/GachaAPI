package com.gachaapi.Battle;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;


@Data
@AllArgsConstructor

public class BattleLogEntry implements Serializable {
    private String entry;
    private EntryType type;
    private Side side;

}
