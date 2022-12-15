package com.gachaapi.Repository;

import com.gachaapi.Entity.Dungeon;
import com.gachaapi.Entity.Dungeonfloor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DungeonFloorRepository extends JpaRepository<Dungeonfloor, Integer> {

    List<Dungeonfloor> findAllByDungeon(Dungeon dungeon);
}
