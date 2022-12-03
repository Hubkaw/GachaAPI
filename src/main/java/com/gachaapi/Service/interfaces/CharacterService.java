package com.gachaapi.Service.interfaces;

import com.gachaapi.Entity.Character;
import com.gachaapi.Utils.dev.NewCharacter;

import java.util.List;

public interface CharacterService {
    List<Character> getAll();
    void create(NewCharacter newCharacter);

}
