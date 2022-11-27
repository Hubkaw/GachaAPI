package com.gachaapi.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Rarity {
    private int id;
    private String name;
    private String shortcut;
    private int weight;
    @JsonIgnore
    private Collection<Artefact> artefactsById;
    @JsonIgnore
    private Collection<Character> charactersById;
    @JsonIgnore
    private Collection<Weapon> weaponsById;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    @Column(name = "shortcut", nullable = false, length = 3)
    public String getShortcut() {
        return shortcut;
    }

    public void setShortcut(String shortcut) {
        this.shortcut = shortcut;
    }

    @Basic
    @Column(name = "weight", nullable = false)
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rarity rarity = (Rarity) o;
        return id == rarity.id && shortcut == rarity.shortcut && weight == rarity.weight && Objects.equals(name, rarity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, shortcut, weight);
    }

    @OneToMany(mappedBy = "rarity")
    @JsonIgnore
    public Collection<Artefact> getArtefactsById() {
        return artefactsById;
    }

    public void setArtefactsById(Collection<Artefact> artefactsById) {
        this.artefactsById = artefactsById;
    }

    @OneToMany(mappedBy = "rarityByRarityId")
    @JsonIgnore
    public Collection<Character> getCharactersById() {
        return charactersById;
    }

    public void setCharactersById(Collection<Character> charactersById) {
        this.charactersById = charactersById;
    }

    @OneToMany(mappedBy = "rarity")
    @JsonIgnore
    public Collection<Weapon> getWeaponsById() {
        return weaponsById;
    }

    public void setWeaponsById(Collection<Weapon> weaponsById) {
        this.weaponsById = weaponsById;
    }
}
