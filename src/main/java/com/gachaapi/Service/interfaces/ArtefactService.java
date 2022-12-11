package com.gachaapi.Service.interfaces;


import com.gachaapi.Entity.Artefact;
import com.gachaapi.Utils.ArtefactType;
import com.gachaapi.Utils.dev.NewArtefact;
import com.gachaapi.Utils.dev.NewArtefactSet;
import com.gachaapi.Utils.dev.NewStatArtefact;

import java.util.List;

public interface ArtefactService {
    List<Artefact> getAll();
    List<Artefact> getAllByType(ArtefactType artefactType);

    void create(NewArtefact newArtefact);

    void delete(int id);

    Artefact getById(int id);

    void createStatArtefact(NewStatArtefact newStatArtefact);
    void deleteStatArtefact(int id);

    void createArtefactSet(NewArtefactSet newArtefactSet);
    void deleteArtefactSet(int setId, int artefactId);
}