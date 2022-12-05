package com.gachaapi.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "artefact_reward", schema = "gacha", catalog = "")
public class ArtefactReward {
    private int id;
    private int quantity;
    private Artefact artefactByArtefactId;
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
        ArtefactReward that = (ArtefactReward) o;
        return id == that.id && quantity == that.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantity);
    }

    @ManyToOne
    @JoinColumn(name = "Artefact_Id", referencedColumnName = "Id", nullable = false)
    public Artefact getArtefactByArtefactId() {
        return artefactByArtefactId;
    }

    public void setArtefactByArtefactId(Artefact artefactByArtefactId) {
        this.artefactByArtefactId = artefactByArtefactId;
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
