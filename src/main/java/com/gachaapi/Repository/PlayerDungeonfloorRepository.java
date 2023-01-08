package com.gachaapi.Repository;

import com.gachaapi.Entity.Dungeonfloor;
import com.gachaapi.Entity.Player;
import com.gachaapi.Entity.PlayerDungeonfloor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerDungeonfloorRepository  extends JpaRepository<PlayerDungeonfloor, Integer> {
    void deletePlayerDungeonfloorByPlayerIdPlayerAndDungeonfloorId(int playerId, int dungeonFloorId);
}
