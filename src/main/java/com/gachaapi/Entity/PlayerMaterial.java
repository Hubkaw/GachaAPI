package com.gachaapi.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "player_material", schema = "gacha", catalog = "",
uniqueConstraints = @UniqueConstraint(columnNames = {"Material_Id", "Player_IdPlayer"}))
public class PlayerMaterial {
    private int id;
    private int amount;
    private Material material;
    @JsonIgnore
    private Player player;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return id == that.id && amount == that.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount);
    }

    @ManyToOne
    @JoinColumn(name = "Material_Id", referencedColumnName = "Id", nullable = false)
    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material materialByMaterialId) {
        this.material = materialByMaterialId;
    }

    @ManyToOne
    @JoinColumn(name = "Player_IdPlayer", referencedColumnName = "IdPlayer", nullable = false)
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player playerByPlayerIdPlayer) {
        this.player = playerByPlayerIdPlayer;
    }
}
