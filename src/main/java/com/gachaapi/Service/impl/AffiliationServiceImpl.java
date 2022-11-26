package com.gachaapi.Service.impl;

import com.gachaapi.Entity.Affilation;
import com.gachaapi.Entity.Materialaffilation;
import com.gachaapi.Entity.StatAffiliation;
import com.gachaapi.Repository.*;
import com.gachaapi.Service.interfaces.AffiliationService;
import com.gachaapi.Utils.dev.NewAffiliation;
import com.gachaapi.Utils.dev.NewAffiliationStat;
import com.gachaapi.Utils.dev.NewMaterialAffiliation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AffiliationServiceImpl implements AffiliationService {

    private AffiliationRepository affiliationRepository;
    private StatAffiliationRepository statAffiliationRepository;
    private StatisticRepository statisticRepository;
    private MaterialAffiliationRepository materialAffiliationRepository;
    private MaterialRepository materialRepository;

    @Override
    public List<Affilation> getAll() {
        return affiliationRepository.findAll();
    }

    @Override
    public void create(NewAffiliation newAffiliation) {
        affiliationRepository.save(newAffiliation.create());
    }

    @Override
    public void delete(int id) {
        affiliationRepository.deleteById(id);
    }

    @Override
    public Affilation getById(int id) {
        return affiliationRepository.getReferenceById(id);
    }

    @Override
    public void addStat(NewAffiliationStat newAffiliationStat) {
        StatAffiliation statAffiliation = new StatAffiliation();
        statAffiliation.setStatistic(statisticRepository.getReferenceById(newAffiliationStat.getStatId()));
        statAffiliation.setAffiliation(affiliationRepository.getReferenceById(newAffiliationStat.getAffiliationId()));
        statAffiliation.setValue(newAffiliationStat.getValue());
        statAffiliationRepository.save(statAffiliation);
    }

    @Override
    public void deleteStat(int id) {
        statAffiliationRepository.deleteById(id);
    }

    @Override
    public void addMaterial(NewMaterialAffiliation newMaterialAffiliation) {
        Materialaffilation ma = new Materialaffilation();
        ma.setMaterial(materialRepository.getReferenceById(newMaterialAffiliation.getMaterialId()));
        ma.setAffilation(affiliationRepository.getReferenceById(newMaterialAffiliation.getAffiliationId()));
        ma.setBaseAmount(newMaterialAffiliation.getBaseAmount());
        ma.setPerLvlAmount(newMaterialAffiliation.getPerLvlAmount());
        materialAffiliationRepository.save(ma);
    }

    @Override
    public void deleteMaterial(int id) {
        materialAffiliationRepository.deleteById(id);
    }
}
