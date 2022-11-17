package com.gachaapi.Utils.dev;

import com.gachaapi.Entity.Rarity;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class NewRarity {
    private String name;
    private String shortcut;
    private int weight;

    public Rarity createRarity(){
        Rarity rarity = new Rarity();
        rarity.setShortcut(shortcut);
        rarity.setName(name);
        rarity.setWeight(weight);
        return rarity;
    }
}
