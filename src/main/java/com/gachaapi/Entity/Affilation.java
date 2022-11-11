package com.gachaapi.Entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Affilation {
    private int id;
    private String name;
    private int requirement;
    private int bonusStat;
    private int bonusValue;
    private Collection<Character> charactersById;
    private Collection<Materialaffilation> materialaffilationsById;

    @Id
    @Column(name = "id", nullable = false)
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
    @Column(name = "Requirement", nullable = false)
    public int getRequirement() {
        return requirement;
    }

    public void setRequirement(int requirement) {
        this.requirement = requirement;
    }

    @Basic
    @Column(name = "BonusStat", nullable = false)
    public int getBonusStat() {
        return bonusStat;
    }

    public void setBonusStat(int bonusStat) {
        this.bonusStat = bonusStat;
    }

    @Basic
    @Column(name = "BonusValue", nullable = false)
    public int getBonusValue() {
        return bonusValue;
    }

    public void setBonusValue(int bonusValue) {
        this.bonusValue = bonusValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Affilation that = (Affilation) o;
        return id == that.id && requirement == that.requirement && bonusStat == that.bonusStat && bonusValue == that.bonusValue && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, requirement, bonusStat, bonusValue);
    }

    @OneToMany(mappedBy = "affilationByAffilationId")
    public Collection<Character> getCharactersById() {
        return charactersById;
    }

    public void setCharactersById(Collection<Character> charactersById) {
        this.charactersById = charactersById;
    }

    @OneToMany(mappedBy = "affilationByAffilationId")
    public Collection<Materialaffilation> getMaterialaffilationsById() {
        return materialaffilationsById;
    }

    public void setMaterialaffilationsById(Collection<Materialaffilation> materialaffilationsById) {
        this.materialaffilationsById = materialaffilationsById;
    }
}
