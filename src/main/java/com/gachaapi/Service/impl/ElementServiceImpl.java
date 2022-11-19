package com.gachaapi.Service.impl;

import com.gachaapi.Entity.Element;
import com.gachaapi.Repository.ElementRepository;
import com.gachaapi.Service.interfaces.ElementService;
import com.gachaapi.Utils.dev.NewElement;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ElementServiceImpl implements ElementService {

    private ElementRepository elementRepository;


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
        elementRepository.delete(elementRepository.getReferenceById(id));
    }
}
