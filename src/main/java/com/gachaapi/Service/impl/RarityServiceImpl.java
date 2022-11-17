package com.gachaapi.Service.impl;

import com.gachaapi.Entity.Rarity;
import com.gachaapi.Repository.RarityRepository;
import com.gachaapi.Service.interfaces.RarityService;
import com.gachaapi.Utils.dev.NewRarity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RarityServiceImpl implements RarityService {

    private RarityRepository rarityRepository;


    @Override
    public List<Rarity> getAll() {
        return rarityRepository.findAll();
    }

    @Override
    public void create(NewRarity newRarity) {
        rarityRepository.save(newRarity.createRarity());
    }

    @Override
    public void delete(int id) {
        rarityRepository.delete(rarityRepository.getReferenceById(id));
    }
}
