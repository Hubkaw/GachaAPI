package com.gachaapi.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "material_reward", schema = "gacha", catalog = "")
public class MaterialReward {
    private int id;
    private int quantity;
    private Material material;
    @JsonIgnore
    private Dungeonfloor dungeonFloor;

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
        MaterialReward that = (MaterialReward) o;
        return id == that.id && quantity == that.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantity);
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
    @JoinColumn(name = "DungeonFloor_ID", referencedColumnName = "ID", nullable = false)
    public Dungeonfloor getDungeonFloor() {
        return dungeonFloor;
    }

    public void setDungeonFloor(Dungeonfloor dungeonfloorByDungeonFloorId) {
        this.dungeonFloor = dungeonfloorByDungeonFloorId;
    }
}
