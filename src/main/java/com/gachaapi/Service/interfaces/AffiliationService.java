package com.gachaapi.Service.interfaces;

import com.gachaapi.Entity.Affilation;
import com.gachaapi.Utils.dev.NewAffiliation;
import com.gachaapi.Utils.dev.NewAffiliationStat;
import com.gachaapi.Utils.dev.NewStat;

import java.util.List;

public interface AffiliationService {
    List<Affilation> getAll();
    void create(NewAffiliation newAffiliation);
    void delete(int id);
    Affilation getById(int id);
    void addStat(NewAffiliationStat newAffiliationStat);
    void deleteStat(int id);

}
