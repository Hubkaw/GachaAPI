package com.gachaapi.Service.interfaces;

import com.gachaapi.Entity.PlayerCharacter;
import com.gachaapi.Utils.dev.NewAdminCharacter;

import java.util.List;

public interface AdminCharacterService {
    List<PlayerCharacter> getAll();
    void create(NewAdminCharacter newAdminCharacter);
    void delete(int id);
}
