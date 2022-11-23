package com.gachaapi.Service.interfaces;

import com.gachaapi.Entity.Material;
import com.gachaapi.Utils.dev.NewMaterial;

import java.util.List;

public interface MaterialService {
    List<Material> getAll();
    void create(NewMaterial newMaterial);
    void delete(int id);
}
