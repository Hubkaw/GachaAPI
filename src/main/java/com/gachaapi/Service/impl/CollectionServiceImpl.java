package com.gachaapi.Service.impl;

import com.gachaapi.Entity.Collection;
import com.gachaapi.Repository.CollectionRepository;
import com.gachaapi.Service.interfaces.CollectionService;
import com.gachaapi.Utils.dev.NewCollection;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CollectionServiceImpl implements CollectionService {

    private CollectionRepository collectionRepository;

    @Override
    public List<Collection> getAll() {
        return collectionRepository.findAll();
    }

    @Override
    public void create(NewCollection newCollection) {
        collectionRepository.save(newCollection.create());
    }

    @Override
    public void delete(int id) {
        collectionRepository.deleteById(id);
    }
}
