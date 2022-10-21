package com.gachaapi.Model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class DungeonFloorDungeonPK implements Serializable {
    private int dungeonFloorId;
    private int dungeonId;

    @Column(name = "DungeonFloor_ID", nullable = false)
    @Id
    public int getDungeonFloorId() {
        return dungeonFloorId;
    }

    public void setDungeonFloorId(int dungeonFloorId) {
        this.dungeonFloorId = dungeonFloorId;
    }

    @Column(name = "Dungeon_ID", nullable = false)
    @Id
    public int getDungeonId() {
        return dungeonId;
    }

    public void setDungeonId(int dungeonId) {
        this.dungeonId = dungeonId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DungeonFloorDungeonPK that = (DungeonFloorDungeonPK) o;
        return dungeonFloorId == that.dungeonFloorId && dungeonId == that.dungeonId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dungeonFloorId, dungeonId);
    }
}
