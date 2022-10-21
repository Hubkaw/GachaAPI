package com.gachaapi.Model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class WeaponClass {
    private int id;
    private String name;
    private int shortcut;
    private Collection<Clazz> clazzesById;
    private Collection<MaterialWeaponClass> materialWeaponClassesById;
    private Collection<Weapon> weaponsById;

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
    @Column(name = "Shortcut", nullable = false)
    public int getShortcut() {
        return shortcut;
    }

    public void setShortcut(int shortcut) {
        this.shortcut = shortcut;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeaponClass that = (WeaponClass) o;
        return id == that.id && shortcut == that.shortcut && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, shortcut);
    }

    @OneToMany(mappedBy = "weaponClassByWeaponClass")
    public Collection<Clazz> getClazzesById() {
        return clazzesById;
    }

    public void setClazzesById(Collection<Clazz> clazzesById) {
        this.clazzesById = clazzesById;
    }

    @OneToMany(mappedBy = "weaponClassByWeaponClassId")
    public Collection<MaterialWeaponClass> getMaterialWeaponClassesById() {
        return materialWeaponClassesById;
    }

    public void setMaterialWeaponClassesById(Collection<MaterialWeaponClass> materialWeaponClassesById) {
        this.materialWeaponClassesById = materialWeaponClassesById;
    }

    @OneToMany(mappedBy = "weaponClassByWeaponClassId")
    public Collection<Weapon> getWeaponsById() {
        return weaponsById;
    }

    public void setWeaponsById(Collection<Weapon> weaponsById) {
        this.weaponsById = weaponsById;
    }
}
