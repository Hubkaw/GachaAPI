package com.gachaapi.Service.impl;

import com.gachaapi.Entity.Affilation;
import com.gachaapi.Entity.StatAffiliation;
import com.gachaapi.Repository.AffiliationRepository;
import com.gachaapi.Repository.StatAffiliationRepository;
import com.gachaapi.Repository.StatisticRepository;
import com.gachaapi.Service.interfaces.AffiliationService;
import com.gachaapi.Utils.dev.NewAffiliation;
import com.gachaapi.Utils.dev.NewAffiliationStat;
import com.gachaapi.Utils.dev.NewStat;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AffiliationServiceImpl implements AffiliationService {

    private AffiliationRepository affiliationRepository;
    private StatAffiliationRepository statAffiliationRepository;
    private StatisticRepository statisticRepository;

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
}
