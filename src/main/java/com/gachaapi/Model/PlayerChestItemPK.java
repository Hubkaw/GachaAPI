package com.gachaapi.Model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class PlayerChestItemPK implements Serializable {
    private int playerIdPlayer;
    private int chestIdChest;

    @Column(name = "Player_IdPlayer", nullable = false)
    @Id
    public int getPlayerIdPlayer() {
        return playerIdPlayer;
    }

    public void setPlayerIdPlayer(int playerIdPlayer) {
        this.playerIdPlayer = playerIdPlayer;
    }

    @Column(name = "Chest_IdChest", nullable = false)
    @Id
    public int getChestIdChest() {
        return chestIdChest;
    }

    public void setChestIdChest(int chestIdChest) {
        this.chestIdChest = chestIdChest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerChestItemPK that = (PlayerChestItemPK) o;
        return playerIdPlayer == that.playerIdPlayer && chestIdChest == that.chestIdChest;
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerIdPlayer, chestIdChest);
    }
}
