package com.gachaapi.Utils.dev;

import com.gachaapi.Entity.Element;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NewElement {
    private String name;

    public Element createElement(){
        Element element = new Element();
        element.setName(name);
        return element;
    }
}
