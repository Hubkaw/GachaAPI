package com.gachaapi.Service.impl;

import com.gachaapi.Entity.Element;
import com.gachaapi.Entity.Materialelement;
import com.gachaapi.Repository.ElementRepository;
import com.gachaapi.Repository.MaterialElementRepository;
import com.gachaapi.Repository.MaterialRepository;
import com.gachaapi.Service.interfaces.ElementService;
import com.gachaapi.Service.interfaces.MaterialService;
import com.gachaapi.Utils.dev.NewElement;
import com.gachaapi.Utils.dev.NewMaterialElement;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ElementServiceImpl implements ElementService {

    private ElementRepository elementRepository;
    private MaterialRepository materialRepository;
    private MaterialElementRepository materialElementRepository;

    @Override
    public List<Element> getAll() {
        return elementRepository.findAll();
    }

    @Override
    public void create(NewElement newElement) {
        elementRepository.save(newElement.createElement());
    }

    @Override
    public void delete(int id) {
        elementRepository.deleteById(id);
    }

    @Override
    public void addMaterial(NewMaterialElement newMaterialElement) {
        Materialelement materialelement = new Materialelement();
        materialelement.setMaterial(materialRepository.getReferenceById(newMaterialElement.getMaterialId()));
        materialelement.setElement(elementRepository.getReferenceById(newMaterialElement.getElementId()));
        materialelement.setBaseAmount(newMaterialElement.getBaseAmount());
        materialelement.setPerLvlAmount(newMaterialElement.getPerLvlAmount());
        materialElementRepository.save(materialelement);
    }

    @Override
    public void deleteMaterial(int id) {
        materialElementRepository.deleteById(id);
    }

    @Override
    public Element getById(int id) {
        return elementRepository.getReferenceById(id);
    }
}
