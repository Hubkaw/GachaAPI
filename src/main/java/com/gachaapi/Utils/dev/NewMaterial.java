package com.gachaapi.Utils.dev;

import com.gachaapi.Entity.Material;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@AllArgsConstructor
@Data
public class NewMaterial {
    private String name;

    public Material create(){
        Material material = new Material();
        material.setName(name);
        material.setMaterialRewardsById(new ArrayList<>());
        material.setMaterialaffilationsById(new ArrayList<>());
        material.setMaterialclassesById(new ArrayList<>());
        material.setMaterialelementsById(new ArrayList<>());
        material.setMaterialweaponclassesById(new ArrayList<>());
        material.setPlayerMaterialsById(new ArrayList<>());
        return material;
    }
}
