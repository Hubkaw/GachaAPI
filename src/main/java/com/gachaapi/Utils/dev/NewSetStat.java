package com.gachaapi.Utils.dev;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NewSetStat {
    private int setId;
    private int statId;
    private int value;
}
