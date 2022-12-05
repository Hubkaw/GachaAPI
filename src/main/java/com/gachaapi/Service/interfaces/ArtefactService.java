package com.gachaapi.Service.interfaces;


import com.gachaapi.Entity.Artefact;
import com.gachaapi.Utils.dev.NewArtefact;
import com.gachaapi.Utils.dev.NewStatArtefact;
import com.gachaapi.Utils.dev.NewStatWeapon;

import java.util.List;

public interface ArtefactService {
    List<Artefact> getAll();

    void create(NewArtefact newArtefact);

    void delete(int id);

    Artefact getById(int id);

    void createStatArtefact(NewStatArtefact newStatArtefact);
    void deleteStatArtefact(int id);
}