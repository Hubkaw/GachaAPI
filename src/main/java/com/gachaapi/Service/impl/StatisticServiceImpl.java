package com.gachaapi.Service.impl;

import com.gachaapi.Entity.Statistic;
import com.gachaapi.Repository.StatisticRepository;
import com.gachaapi.Service.interfaces.StatisticService;
import com.gachaapi.Utils.dev.NewStat;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StatisticServiceImpl implements StatisticService {

    StatisticRepository statisticRepository;

    @Override
    public List<Statistic> getAll() {
        return statisticRepository.findAll();
    }

    @Override
    public void addStat(NewStat newStat) {
        Statistic stat = new Statistic();
        stat.setName(newStat.getName());
        stat.setShortName(newStat.getShortName());
        statisticRepository.save(stat);
    }

    @Override
    public void delete(int id) {
        statisticRepository.deleteById(id);
    }
}
