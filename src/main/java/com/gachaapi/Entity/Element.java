package com.gachaapi.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Element {
    private int id;
    private String name;
    @JsonIgnore
    private Collection<Materialelement> materialelementsById;
    @JsonIgnore
    private Collection<Weapon> weaponsById;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Element element = (Element) o;
        return id == element.id && Objects.equals(name, element.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @OneToMany(mappedBy = "elementByElementId")
    public Collection<Materialelement> getMaterialelementsById() {
        return materialelementsById;
    }

    public void setMaterialelementsById(Collection<Materialelement> materialelementsById) {
        this.materialelementsById = materialelementsById;
    }

    @OneToMany(mappedBy = "element")
    public Collection<Weapon> getWeaponsById() {
        return weaponsById;
    }

    public void setWeaponsById(Collection<Weapon> weaponsById) {
        this.weaponsById = weaponsById;
    }
}
