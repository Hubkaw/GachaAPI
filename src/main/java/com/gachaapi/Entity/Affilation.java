package com.gachaapi.Entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Affilation {
    private int id;
    private String name;
    private int requirement;
    private Collection<Character> characters;
    private Collection<Materialaffilation> materialAffilations;
    private Collection<StatAffiliation> statAffiliations;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Affilation that = (Affilation) o;
        return id == that.id && requirement == that.requirement  && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, requirement);
    }

    @OneToMany(mappedBy = "affilationByAffilationId")
    public Collection<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(Collection<Character> charactersById) {
        this.characters = charactersById;
    }

    @OneToMany(mappedBy = "affilationByAffilationId")
    public Collection<Materialaffilation> getMaterialAffilations() {
        return materialAffilations;
    }

    public void setMaterialAffilations(Collection<Materialaffilation> materialaffilationsById) {
        this.materialAffilations = materialaffilationsById;
    }

    @OneToMany(mappedBy = "affiliation")
    public Collection<StatAffiliation> getStatAffiliations() {
        return statAffiliations;
    }

    public void setStatAffiliations(Collection<StatAffiliation> statAffiliations) {
        this.statAffiliations = statAffiliations;
    }
}
