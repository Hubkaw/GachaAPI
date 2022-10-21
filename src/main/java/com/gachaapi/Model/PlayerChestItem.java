package com.gachaapi.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Player_ChestItem", schema = "dbo", catalog = "gacha")
@IdClass(PlayerChestItemPK.class)
public class PlayerChestItem {
    private int playerIdPlayer;
    private int chestIdChest;
    private Object boughtAt;
    private Player playerByPlayerIdPlayer;
    private Chest chestByChestIdChest;

    @Id
    @Column(name = "Player_IdPlayer", nullable = false)
    public int getPlayerIdPlayer() {
        return playerIdPlayer;
    }

    public void setPlayerIdPlayer(int playerIdPlayer) {
        this.playerIdPlayer = playerIdPlayer;
    }

    @Id
    @Column(name = "Chest_IdChest", nullable = false)
    public int getChestIdChest() {
        return chestIdChest;
    }

    public void setChestIdChest(int chestIdChest) {
        this.chestIdChest = chestIdChest;
    }

    @Basic
    @Column(name = "BoughtAt", nullable = false)
    public Object getBoughtAt() {
        return boughtAt;
    }

    public void setBoughtAt(Object boughtAt) {
        this.boughtAt = boughtAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerChestItem that = (PlayerChestItem) o;
        return playerIdPlayer == that.playerIdPlayer && chestIdChest == that.chestIdChest && Objects.equals(boughtAt, that.boughtAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerIdPlayer, chestIdChest, boughtAt);
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
