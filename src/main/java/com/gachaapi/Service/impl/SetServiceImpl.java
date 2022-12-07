package com.gachaapi.Service.impl;

import com.gachaapi.Entity.Set;
import com.gachaapi.Entity.StatArtefactset;
import com.gachaapi.Repository.SetRepository;
import com.gachaapi.Repository.SetStatsRepository;
import com.gachaapi.Repository.StatisticRepository;
import com.gachaapi.Service.interfaces.SetService;
import com.gachaapi.Utils.dev.NewSet;
import com.gachaapi.Utils.dev.NewSetStat;
import com.sun.jdi.request.InvalidRequestStateException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SetServiceImpl implements SetService {

    private SetRepository setRepository;
    private SetStatsRepository setStatsRepository;
    private StatisticRepository statisticRepository;

    @Override
    public List<Set> getAll() {
        return setRepository.findAll();
    }

    @Override
    public void create(NewSet newSet) {
        Set set = newSet.create();
        setRepository.save(set);
    }

    @Override
    public void delete(int id) {
        setRepository.deleteById(id);
    }

    @Override
    public Set getById(int id) {
        return setRepository.findById(id).orElseThrow();
    }

    @Override
    public void createSetStat(NewSetStat newSetStat) {
        StatArtefactset setStat = new StatArtefactset();
        setStat.setValue(newSetStat.getValue());
        setStat.setStat(statisticRepository.getReferenceById(newSetStat.getStatId()));
        setStat.setSet(setRepository.getReferenceById(newSetStat.getSetId()));
        setStatsRepository.save(setStat);
    }

    @Override
    public void deleteSetStat(int id) {
        setStatsRepository.deleteById(id);
    }
}
