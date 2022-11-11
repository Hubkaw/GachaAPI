package com.gachaapi.Entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "class", schema = "gacha", catalog = "")
public class Clazz {
    private int id;
    private String name;
    private int uniqueStat;
    private String shortcut;
    private Collection<Character> charactersById;
    private Weaponclass weaponclassByWeaponClass;
    private Collection<Materialclass> materialclassesById;
    private Collection<StatClass> statClassesById;

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
    @Column(name = "UniqueStat", nullable = false)
    public int getUniqueStat() {
        return uniqueStat;
    }

    public void setUniqueStat(int uniqueStat) {
        this.uniqueStat = uniqueStat;
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
        return id == clazz.id && uniqueStat == clazz.uniqueStat && Objects.equals(name, clazz.name) && Objects.equals(shortcut, clazz.shortcut);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, uniqueStat, shortcut);
    }

    @OneToMany(mappedBy = "clazzByClassId")
    public Collection<Character> getCharactersById() {
        return charactersById;
    }

    public void setCharactersById(Collection<Character> charactersById) {
        this.charactersById = charactersById;
    }

    @ManyToOne
    @JoinColumn(name = "WeaponClass", referencedColumnName = "Id", nullable = false)
    public Weaponclass getWeaponclassByWeaponClass() {
        return weaponclassByWeaponClass;
    }

    public void setWeaponclassByWeaponClass(Weaponclass weaponclassByWeaponClass) {
        this.weaponclassByWeaponClass = weaponclassByWeaponClass;
    }

    @OneToMany(mappedBy = "clazzByClassId")
    public Collection<Materialclass> getMaterialclassesById() {
        return materialclassesById;
    }

    public void setMaterialclassesById(Collection<Materialclass> materialclassesById) {
        this.materialclassesById = materialclassesById;
    }

    @OneToMany(mappedBy = "clazzByClassId")
    public Collection<StatClass> getStatClassesById() {
        return statClassesById;
    }

    public void setStatClassesById(Collection<StatClass> statClassesById) {
        this.statClassesById = statClassesById;
    }
}
