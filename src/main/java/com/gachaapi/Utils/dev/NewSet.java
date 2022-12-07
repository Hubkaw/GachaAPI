package com.gachaapi.Utils.dev;

import com.gachaapi.Entity.Set;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NewSet {
    private String name;

    public Set create(){
        Set set = new Set();
        set.setName(name);
        return set;
    }
}
