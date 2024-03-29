package com.gachaapi.Service.impl;


import com.gachaapi.Entity.Artefact;
import com.gachaapi.Entity.StatArtifact;
import com.gachaapi.Repository.*;
import com.gachaapi.Service.interfaces.ArtefactService;
import com.gachaapi.Utils.ArtefactType;
import com.gachaapi.Utils.dev.NewArtefact;
import com.gachaapi.Utils.dev.NewArtefactSet;
import com.gachaapi.Utils.dev.NewStatArtefact;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ArtefactServiceImpl implements ArtefactService {

    private ArtefactRepository artefactRepository;
    private RarityRepository rarityRepository;
    private StatArtefactRepository statArtefactRepository;
    private StatisticRepository statisticRepository;
    private SetRepository setRepository;


    @Override
    public List<Artefact> getAll() {
        return artefactRepository.findAll();
    }

    @Override
    public List<Artefact> getAllByType(ArtefactType artefactType) {
        return artefactRepository.findAllByType(artefactType);
    }

    @Override
    public void create(NewArtefact newArtefact) {
        Artefact artefact = newArtefact.create();
        artefact.setRarity(rarityRepository.getReferenceById(newArtefact.getRarityId()));
        artefactRepository.save(artefact);
    }

    @Override
    public void delete(int id){
        Artefact artefact = artefactRepository.getReferenceById(id);
        if (artefact.getPlayerArtefacts().isEmpty())
            artefactRepository.deleteById(id);
    }

    @Override
    public Artefact getById(int id) {
        return artefactRepository.getReferenceById(id);
    }

    @Override
    public void createStatArtefact(NewStatArtefact newStatArtefact) {
        StatArtifact statArtefact = new StatArtifact();
        statArtefact.setStats(statisticRepository.getReferenceById(newStatArtefact.getStatId()));
        statArtefact.setArtefactByArtefactId(artefactRepository.getReferenceById(newStatArtefact.getArtefactId()));
        statArtefact.setValue(newStatArtefact.getValue());
        statArtefactRepository.saveAndFlush(statArtefact);
    }

    @Override
    public void deleteStatArtefact(int id) {
        statArtefactRepository.deleteById(id);
    }

    @Override
    public void createArtefactSet(NewArtefactSet newArtefactSet) {
        Artefact artefact = artefactRepository.getReferenceById(newArtefactSet.getArtefactId());
        artefact.getSets().add(setRepository.getReferenceById(newArtefactSet.getSetId()));
        artefactRepository.save(artefact);
    }

    @Override
    public void deleteArtefactSet(int setId, int artefactId) {
        Artefact artefact = artefactRepository.getReferenceById(artefactId);
        artefact.getSets().removeIf(s -> s.getId()==setId);
        artefactRepository.save(artefact);
    }


}
