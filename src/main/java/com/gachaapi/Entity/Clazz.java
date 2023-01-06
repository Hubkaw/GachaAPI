package com.gachaapi.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "class", catalog = "")
public class Clazz {
    private int id;
    private String name;
    private String shortcut;
    @JsonIgnore
    private Collection<Character> characters;
    private Weaponclass weaponClass;
    private Collection<Materialclass> materialClasses;
    private Collection<StatClass> stats;

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


    @Basic
    @Column(name = "Shortcut", nullable = false, length = 3)
    public String getShortcut() {
        return shortcut;
    }

    public void setShortcut(String shortcut) {
        this.shortcut = shortcut;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clazz clazz = (Clazz) o;
        return id == clazz.id &&  Objects.equals(name, clazz.name) && Objects.equals(shortcut, clazz.shortcut);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, shortcut);
    }

    @OneToMany(mappedBy = "characterClass")
    public Collection<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(Collection<Character> charactersById) {
        this.characters = charactersById;
    }

    @ManyToOne
    @JoinColumn(name = "WeaponClass", referencedColumnName = "Id", nullable = false)
    public Weaponclass getWeaponClass() {
        return weaponClass;
    }

    public void setWeaponClass(Weaponclass weaponclassByWeaponClass) {
        this.weaponClass = weaponclassByWeaponClass;
    }

    @OneToMany(mappedBy = "clazz")
    public Collection<Materialclass> getMaterialClasses() {
        return materialClasses;
    }

    public void setMaterialClasses(Collection<Materialclass> materialclassesById) {
        this.materialClasses = materialclassesById;
    }

    @OneToMany(mappedBy = "clazz")
    public Collection<StatClass> getStats() {
        return stats;
    }

    public void setStats(Collection<StatClass> statClassesById) {
        this.stats = statClassesById;
    }
}
