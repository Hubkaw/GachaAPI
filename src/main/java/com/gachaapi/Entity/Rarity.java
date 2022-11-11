package com.gachaapi.Entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Rarity {
    private int id;
    private String name;
    private int shortcut;
    private int weight;
    private Collection<Artefact> artefactsById;
    private Collection<Character> charactersById;
    private Collection<Weapon> weaponsById;

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
    @Column(name = "shortcut", nullable = false)
    public int getShortcut() {
        return shortcut;
    }

    public void setShortcut(int shortcut) {
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

    @OneToMany(mappedBy = "rarityByRarityId")
    public Collection<Artefact> getArtefactsById() {
        return artefactsById;
    }

    public void setArtefactsById(Collection<Artefact> artefactsById) {
        this.artefactsById = artefactsById;
    }

    @OneToMany(mappedBy = "rarityByRarityId")
    public Collection<Character> getCharactersById() {
        return charactersById;
    }

    public void setCharactersById(Collection<Character> charactersById) {
        this.charactersById = charactersById;
    }

    @OneToMany(mappedBy = "rarityByRarityId")
    public Collection<Weapon> getWeaponsById() {
        return weaponsById;
    }

    public void setWeaponsById(Collection<Weapon> weaponsById) {
        this.weaponsById = weaponsById;
    }
}
