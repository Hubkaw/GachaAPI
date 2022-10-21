package com.gachaapi.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Player_DungeonFloor", schema = "dbo", catalog = "gacha")
@IdClass(PlayerDungeonFloorPK.class)
public class PlayerDungeonFloor {
    private int dungeonFloorId;
    private int playerIdPlayer;
    private DungeonFloor dungeonFloorByDungeonFloorId;
    private Player playerByPlayerIdPlayer;

    @Id
    @Column(name = "DungeonFloor_ID", nullable = false)
    public int getDungeonFloorId() {
        return dungeonFloorId;
    }

    public void setDungeonFloorId(int dungeonFloorId) {
        this.dungeonFloorId = dungeonFloorId;
    }

    @Id
    @Column(name = "Player_IdPlayer", nullable = false)
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
        PlayerDungeonFloor that = (PlayerDungeonFloor) o;
        return dungeonFloorId == that.dungeonFloorId && playerIdPlayer == that.playerIdPlayer;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dungeonFloorId, playerIdPlayer);
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
    @JoinColumn(name = "Player_IdPlayer", referencedColumnName = "IdPlayer", nullable = false)
    public Player getPlayerByPlayerIdPlayer() {
        return playerByPlayerIdPlayer;
    }

    public void setPlayerByPlayerIdPlayer(Player playerByPlayerIdPlayer) {
        this.playerByPlayerIdPlayer = playerByPlayerIdPlayer;
    }
}
