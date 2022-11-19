package com.gachaapi.Service.interfaces;

import com.gachaapi.Entity.Element;
import com.gachaapi.Utils.dev.NewElement;

import java.util.List;

public interface ElementService {
    List<Element> getAll();
    void create(NewElement newElement);
    void delete(int id);
}
