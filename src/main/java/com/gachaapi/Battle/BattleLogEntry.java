package com.gachaapi.Battle;

import lombok.Data;


@Data
public class BattleLogEntry {
    private String entry;
    private EntryType type;
    private Side side;

    public BattleLogEntry(String entry, EntryType type, Side side) {
        this.entry = entry;
        this.type = type;
        this.side = side;
    }


}
