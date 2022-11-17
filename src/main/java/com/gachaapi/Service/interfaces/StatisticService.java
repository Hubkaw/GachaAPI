package com.gachaapi.Service.interfaces;

import com.gachaapi.Entity.Statistic;
import com.gachaapi.Utils.dev.NewStat;

import java.util.List;

public interface StatisticService {
    List<Statistic> getAll();
    void addStat(NewStat newStat);
    void delete(int id);
}
