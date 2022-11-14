package com.gachaapi.Service.impl;

import com.gachaapi.Entity.Statistic;
import com.gachaapi.Repository.StatisticRepository;
import com.gachaapi.Service.interfaces.StatisticService;
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
}
