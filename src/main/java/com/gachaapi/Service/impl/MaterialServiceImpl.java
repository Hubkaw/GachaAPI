package com.gachaapi.Service.impl;

import com.gachaapi.Entity.Material;
import com.gachaapi.Repository.MaterialRepository;
import com.gachaapi.Service.interfaces.MaterialService;
import com.gachaapi.Utils.dev.NewMaterial;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MaterialServiceImpl implements MaterialService {

    private MaterialRepository materialRepository;


    @Override
    public List<Material> getAll() {
        return materialRepository.findAll();
    }

    @Override
    public void create(NewMaterial newMaterial) {
        Material material = newMaterial.create();
        materialRepository.save(material);
    }

    @Override
    public void delete(int id) {
        materialRepository.deleteById(id);
    }
}
