package com.gachaapi.Utils.api;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NewParty {
    private String name;
    private int char1Id;
    private int char2Id;
    private int char3Id;
    private int char4Id;

}
