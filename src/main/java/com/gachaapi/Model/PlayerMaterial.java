package com.gachaapi.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Player_Material", schema = "dbo", catalog = "gacha")
@IdClass(PlayerMaterialPK.class)
public class PlayerMaterial {
    private int materialId;
    private int playerIdPlayer;
    private int amount;
    private Material materialByMaterialId;
    private Player playerByPlayerIdPlayer;

    @Id
    @Column(name = "Material_Id", nullable = false)
    public int getMaterialId() {
        return materialId;
    }

    public void setMaterialId(int materialId) {
        this.materialId = materialId;
    }

    @Id
    @Column(name = "Player_IdPlayer", nullable = false)
    public int getPlayerIdPlayer() {
        return playerIdPlayer;
    }

    public void setPlayerIdPlayer(int playerIdPlayer) {
        this.playerIdPlayer = playerIdPlayer;
    }

    @Basic
    @Column(name = "Amount", nullable = false)
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerMaterial that = (PlayerMaterial) o;
        return materialId == that.materialId && playerIdPlayer == that.playerIdPlayer && amount == that.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(materialId, playerIdPlayer, amount);
    }

    @ManyToOne
    @JoinColumn(name = "Material_Id", referencedColumnName = "Id", nullable = false)
    public Material getMaterialByMaterialId() {
        return materialByMaterialId;
    }

    public void setMaterialByMaterialId(Material materialByMaterialId) {
        this.materialByMaterialId = materialByMaterialId;
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
