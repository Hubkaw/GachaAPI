package com.gachaapi.Model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class PlayerDungeonFloorPK implements Serializable {
    private int dungeonFloorId;
    private int playerIdPlayer;

    @Column(name = "DungeonFloor_ID", nullable = false)
    @Id
    public int getDungeonFloorId() {
        return dungeonFloorId;
    }

    public void setDungeonFloorId(int dungeonFloorId) {
        this.dungeonFloorId = dungeonFloorId;
    }

    @Column(name = "Player_IdPlayer", nullable = false)
    @Id
    public int getPlayerIdPlayer() {
        return playerIdPlayer;
    }

    public void setPlayerIdPlayer(int playerIdPlayer) {
        this.playerIdPlayer = playerIdPlayer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerDungeonFloorPK that = (PlayerDungeonFloorPK) o;
        return dungeonFloorId == that.dungeonFloorId && playerIdPlayer == that.playerIdPlayer;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dungeonFloorId, playerIdPlayer);
    }
}
