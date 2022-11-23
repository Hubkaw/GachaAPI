package com.gachaapi.Utils.dev;


import com.gachaapi.Entity.Affilation;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@AllArgsConstructor
@Data
public class NewAffiliation {
    private String name;
    private int requirement;

    public Affilation create(){
        Affilation affilation = new Affilation();
        affilation.setName(name);
        affilation.setRequirement(requirement);
        affilation.setStatAffiliations(new ArrayList<>());
        affilation.setCharacters(new ArrayList<>());
        affilation.setMaterialAffilations(new ArrayList<>());
        return affilation;
    }
}
