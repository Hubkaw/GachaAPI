package com.gachaapi.Service.interfaces;

import com.gachaapi.Entity.Rarity;
import com.gachaapi.Utils.dev.NewRarity;

import java.util.List;

public interface RarityService {
    List<Rarity> getAll();
    void create(NewRarity newRarity);
    void delete(int id);
}
