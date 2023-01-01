package com.gachaapi.Service.interfaces;

import com.gachaapi.Entity.Dungeon;
import com.gachaapi.Entity.Element;
import com.gachaapi.Utils.PvEResult;
import com.gachaapi.Utils.dev.NewDungeon;
import com.gachaapi.Utils.dev.NewElement;

import java.util.List;

public interface DungeonService {

    
    List<Dungeon> getAll();
    void create(NewDungeon newDungeon);
    void delete(int id);

    Dungeon getById(int id);
    PvEResult enterDungeon(int floorId, String nickname);
    PvEResult enterDungeon(int floorId, int partyId, String nickname);
}
