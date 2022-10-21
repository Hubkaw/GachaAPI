package com.gachaapi.Model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Set {
    private int id;
    private String name;
    private int bonusStatType;
    private int bonusStatPerPiece;
    private Collection<ArtefactSet> artefactSetsById;

    @Id
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Name", nullable = false, length = 32)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "BonusStatType", nullable = false)
    public int getBonusStatType() {
        return bonusStatType;
    }

    public void setBonusStatType(int bonusStatType) {
        this.bonusStatType = bonusStatType;
    }

    @Basic
    @Column(name = "BonusStatPerPiece", nullable = false)
    public int getBonusStatPerPiece() {
        return bonusStatPerPiece;
    }

    public void setBonusStatPerPiece(int bonusStatPerPiece) {
        this.bonusStatPerPiece = bonusStatPerPiece;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Set set = (Set) o;
        return id == set.id && bonusStatType == set.bonusStatType && bonusStatPerPiece == set.bonusStatPerPiece && Objects.equals(name, set.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, bonusStatType, bonusStatPerPiece);
    }

    @OneToMany(mappedBy = "setBySetId")
    public Collection<ArtefactSet> getArtefactSetsById() {
        return artefactSetsById;
    }

    public void setArtefactSetsById(Collection<ArtefactSet> artefactSetsById) {
        this.artefactSetsById = artefactSetsById;
    }
}
