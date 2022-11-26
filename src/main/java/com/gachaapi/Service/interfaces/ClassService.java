package com.gachaapi.Service.interfaces;

import com.gachaapi.Entity.Clazz;
import com.gachaapi.Utils.dev.NewClass;
import com.gachaapi.Utils.dev.NewMaterialClass;
import com.gachaapi.Utils.dev.NewStatClass;

import java.util.List;

public interface ClassService {
    List<Clazz> getAll();
    void create(NewClass newClass);
    void delete(int id);
    Clazz getById(int id);
    void createStatClass(NewStatClass newStatClass);
    void deleteStatClass(int id);
    void createMaterialClass(NewMaterialClass newMaterialClass);
    void deleteMaterialClass(int id);

}
