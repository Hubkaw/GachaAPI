package com.gachaapi.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "player_chestitem", schema = "gacha", catalog = "")
public class PlayerChestitem {
    private int id;
    private Timestamp boughtAt;
    private Player playerByPlayerIdPlayer;
    private Chest chestByChestIdChest;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "BoughtAt", nullable = false)
    public Timestamp getBoughtAt() {
        return boughtAt;
    }

    public void setBoughtAt(Timestamp boughtAt) {
        this.boughtAt = boughtAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerChestitem that = (PlayerChestitem) o;
        return id == that.id && Objects.equals(boughtAt, that.boughtAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, boughtAt);
    }

    @ManyToOne
    @JoinColumn(name = "Player_IdPlayer", referencedColumnName = "IdPlayer", nullable = false)
    public Player getPlayerByPlayerIdPlayer() {
        return playerByPlayerIdPlayer;
    }

    public void setPlayerByPlayerIdPlayer(Player playerByPlayerIdPlayer) {
        this.playerByPlayerIdPlayer = playerByPlayerIdPlayer;
    }

    @ManyToOne
    @JoinColumn(name = "Chest_IdChest", referencedColumnName = "IdChest", nullable = false)
    public Chest getChestByChestIdChest() {
        return chestByChestIdChest;
    }

    public void setChestByChestIdChest(Chest chestByChestIdChest) {
        this.chestByChestIdChest = chestByChestIdChest;
    }
}
