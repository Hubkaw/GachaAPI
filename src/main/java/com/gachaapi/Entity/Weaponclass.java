package com.gachaapi.Entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Weaponclass {
    private int id;
    private String name;
    private String shortName;
    private Collection<Clazz> clazzesById;
    private Collection<Materialweaponclass> materialweaponclassesById;
    private Collection<Weapon> weaponsById;

    @Id
    @Column(name = "Id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Column(name = "short_name", nullable = false, length = 3)
    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortcut) {
        this.shortName = shortcut;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weaponclass that = (Weaponclass) o;
        return id == that.id && shortName == that.shortName && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, shortName);
    }

    @OneToMany(mappedBy = "weaponclassByWeaponClass")
    public Collection<Clazz> getClazzesById() {
        return clazzesById;
    }

    public void setClazzesById(Collection<Clazz> clazzesById) {
        this.clazzesById = clazzesById;
    }

    @OneToMany(mappedBy = "weaponclassByWeaponClassId")
    public Collection<Materialweaponclass> getMaterialweaponclassesById() {
        return materialweaponclassesById;
    }

    public void setMaterialweaponclassesById(Collection<Materialweaponclass> materialweaponclassesById) {
        this.materialweaponclassesById = materialweaponclassesById;
    }

    @OneToMany(mappedBy = "weaponclassByWeaponClassId")
    public Collection<Weapon> getWeaponsById() {
        return weaponsById;
    }

    public void setWeaponsById(Collection<Weapon> weaponsById) {
        this.weaponsById = weaponsById;
    }
}
