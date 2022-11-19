package com.gachaapi.Service.interfaces;

import com.gachaapi.Entity.Collection;
import com.gachaapi.Utils.dev.NewCollection;

import java.util.List;

public interface CollectionService {
    List<Collection> getAll();
    void create(NewCollection newCollection);
    void delete(int id);
}
