package com.gachaapi.Service.impl;

import com.gachaapi.Entity.Dungeon;
import com.gachaapi.Repository.DungeonRepository;
import com.gachaapi.Service.interfaces.CollectionService;
import com.gachaapi.Service.interfaces.DungeonService;
import com.gachaapi.Utils.dev.NewDungeon;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class DungeonServiceImpl  implements DungeonService {
    private DungeonRepository dungeonRepository;

    @Override
    public List<Dungeon> getAll() {
        return dungeonRepository.findAll();
    }

    @Override
    public void create(NewDungeon newDungeon) {
    dungeonRepository.save(newDungeon.create());
    }

    @Override
    public void delete(int id) {
    dungeonRepository.deleteById(id);
    }
}
