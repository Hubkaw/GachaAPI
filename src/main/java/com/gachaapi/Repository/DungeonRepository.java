package com.gachaapi.Repository;

import com.gachaapi.Entity.Collection;
import com.gachaapi.Entity.Dungeon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DungeonRepository  extends JpaRepository<Dungeon, Integer> {
}
