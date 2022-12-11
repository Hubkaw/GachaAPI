package com.gachaapi.Utils.dev;

import com.gachaapi.Entity.Artefact;
import com.gachaapi.Entity.Dungeon;
import com.gachaapi.Entity.Rarity;
import com.gachaapi.Utils.ArtefactType;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class NewArtefact {
    private String name;
    private String type;
    private int rarityId;

    public Artefact create() {
        Artefact newArtefact = new Artefact();
        newArtefact.setName(name);
        newArtefact.setType(ArtefactType.valueOf(type));
        return newArtefact;
    }
}