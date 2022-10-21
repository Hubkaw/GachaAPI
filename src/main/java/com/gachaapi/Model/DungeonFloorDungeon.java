package com.gachaapi.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "DungeonFloor_Dungeon", schema = "dbo", catalog = "gacha")
@IdClass(DungeonFloorDungeonPK.class)
public class DungeonFloorDungeon {
    private int dungeonFloorId;
    private int dungeonId;
    private DungeonFloor dungeonFloorByDungeonFloorId;
    private Dungeon dungeonByDungeonId;

    @Id
    @Column(name = "DungeonFloor_ID", nullable = false)
    public int getDungeonFloorId() {
        return dungeonFloorId;
    }

    public void setDungeonFloorId(int dungeonFloorId) {
        this.dungeonFloorId = dungeonFloorId;
    }

    @Id
    @Column(name = "Dungeon_ID", nullable = false)
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
        DungeonFloorDungeon that = (DungeonFloorDungeon) o;
        return dungeonFloorId == that.dungeonFloorId && dungeonId == that.dungeonId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dungeonFloorId, dungeonId);
    }

    @ManyToOne
    @JoinColumn(name = "DungeonFloor_ID", referencedColumnName = "ID", nullable = false)
    public DungeonFloor getDungeonFloorByDungeonFloorId() {
        return dungeonFloorByDungeonFloorId;
    }

    public void setDungeonFloorByDungeonFloorId(DungeonFloor dungeonFloorByDungeonFloorId) {
        this.dungeonFloorByDungeonFloorId = dungeonFloorByDungeonFloorId;
    }

    @ManyToOne
    @JoinColumn(name = "Dungeon_ID", referencedColumnName = "ID", nullable = false)
    public Dungeon getDungeonByDungeonId() {
        return dungeonByDungeonId;
    }

    public void setDungeonByDungeonId(Dungeon dungeonByDungeonId) {
        this.dungeonByDungeonId = dungeonByDungeonId;
    }
}
