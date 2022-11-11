package com.gachaapi.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "material_reward", schema = "gacha", catalog = "")
public class MaterialReward {
    private int id;
    private int quantity;
    private Material materialByMaterialId;
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
        MaterialReward that = (MaterialReward) o;
        return id == that.id && quantity == that.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantity);
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
    @JoinColumn(name = "DungeonFloor_ID", referencedColumnName = "ID", nullable = false)
    public Dungeonfloor getDungeonfloorByDungeonFloorId() {
        return dungeonfloorByDungeonFloorId;
    }

    public void setDungeonfloorByDungeonFloorId(Dungeonfloor dungeonfloorByDungeonFloorId) {
        this.dungeonfloorByDungeonFloorId = dungeonfloorByDungeonFloorId;
    }
}
