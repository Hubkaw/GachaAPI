package com.gachaapi.Utils.dev;

import com.gachaapi.Entity.Collection;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class NewCollection {
    private String name;

    public Collection create(){
        Collection collection = new Collection();
        collection.setName(name);
        return collection;
    }
}
