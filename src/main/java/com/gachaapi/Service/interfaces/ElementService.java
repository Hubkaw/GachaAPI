package com.gachaapi.Service.interfaces;

import com.gachaapi.Entity.Element;
import com.gachaapi.Utils.dev.NewElement;
import com.gachaapi.Utils.dev.NewMaterialElement;

import java.util.List;

public interface ElementService {
    List<Element> getAll();
    void create(NewElement newElement);
    void delete(int id);
    void addMaterial(NewMaterialElement newMaterialElement);
    void deleteMaterial(int id);
    Element getById(int id);
}
