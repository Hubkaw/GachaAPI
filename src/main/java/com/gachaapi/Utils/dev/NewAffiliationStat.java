package com.gachaapi.Utils.dev;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NewAffiliationStat {
    private int affiliationId;
    private int statId;
    private int value;
}
