package com.gachaapi.Service.impl;


import com.gachaapi.Entity.Artefact;
import com.gachaapi.Repository.ArtefactRepository;
import com.gachaapi.Repository.RarityRepository;
import com.gachaapi.Service.interfaces.ArtefactService;
import com.gachaapi.Utils.dev.NewArtefact;
import com.gachaapi.Utils.dev.NewDungeon;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ArtefactServiceImpl implements ArtefactService {

    private ArtefactRepository artefactRepository;
    private RarityRepository rarityRepository;


    @Override
    public List<Artefact> getAll() {
        return artefactRepository.findAll();
    }

    @Override
    public void create(NewArtefact newArtefact) {
        Artefact artefact = newArtefact.create();
        artefact.setRarity(rarityRepository.getReferenceById(newArtefact.getRarityId()));
        artefactRepository.save(artefact);
    }

    @Override
    public void delete(int id) {
        artefactRepository.deleteById(id);
    }

    @Override
    public Artefact getById(int id) {
        return artefactRepository.getReferenceById(id);
    }
}
