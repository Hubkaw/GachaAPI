package com.gachaapi.Model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class PlayerMaterialPK implements Serializable {
    private int materialId;
    private int playerIdPlayer;

    @Column(name = "Material_Id", nullable = false)
    @Id
    public int getMaterialId() {
        return materialId;
    }

    public void setMaterialId(int materialId) {
        this.materialId = materialId;
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
        PlayerMaterialPK that = (PlayerMaterialPK) o;
        return materialId == that.materialId && playerIdPlayer == that.playerIdPlayer;
    }

    @Override
    public int hashCode() {
        return Objects.hash(materialId, playerIdPlayer);
    }
}
