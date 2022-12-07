package com.gachaapi.Service.interfaces;

import com.gachaapi.Entity.Set;
import com.gachaapi.Utils.dev.NewSet;
import com.gachaapi.Utils.dev.NewSetStat;

import java.util.List;
import java.util.Optional;

public interface SetService {
    List<Set> getAll();
    void create(NewSet newSet);
    void delete(int id);
    Set getById(int id);
    void createSetStat(NewSetStat newSetStat);
    void deleteSetStat(int id);
}
