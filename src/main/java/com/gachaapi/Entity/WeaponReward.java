package com.gachaapi.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "weapon_reward", schema = "gacha", catalog = "")
public class WeaponReward {
    private int id;
    private int quantity;
    private Weapon weaponByWeaponId;
    @JsonIgnore
    private Dungeonfloor dungeonfloorByDungeonFloorId;

    @Id
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Quantity", nullable = false)
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeaponReward that = (WeaponReward) o;
        return id == that.id && quantity == that.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantity);
    }

    @ManyToOne
    @JoinColumn(name = "Weapon_Id", referencedColumnName = "Id", nullable = false)
    public Weapon getWeaponByWeaponId() {
        return weaponByWeaponId;
    }

    public void setWeaponByWeaponId(Weapon weaponByWeaponId) {
        this.weaponByWeaponId = weaponByWeaponId;
    }

    @ManyToOne
    @JoinColumn(name = "DungeonFloor_ID", referencedColumnName = "ID", nullable = false)
    public Dungeonfloor getDungeonfloorByDungeonFloorId() {
        return dungeonfloorByDungeonFloorId;
    }

    public void setDungeonfloorByDungeonFloorId(Dungeonfloor dungeonfloorByDungeonFloorId) {
        this.dungeonfloorByDungeonFloorId = dungeonfloorByDungeonFloorId;
    }
}
