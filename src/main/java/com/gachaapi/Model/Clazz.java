package com.gachaapi.Model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Class", schema = "dbo", catalog = "gacha")
public class Clazz {
    private int id;
    private String name;
    private int weaponClass;
    private int uniqueStat;
    private String shortcut;
    private int rarityId;
    private Collection<Character> charactersById;
    private WeaponClass weaponClassByWeaponClass;
    private Rarity rarityByRarityId;
    private Collection<MaterialClass> materialClassesById;
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
    @Column(name = "WeaponClass", nullable = false)
    public int getWeaponClass() {
        return weaponClass;
    }

    public void setWeaponClass(int weaponClass) {
        this.weaponClass = weaponClass;
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

    @Basic
    @Column(name = "Rarity_id", nullable = false)
    public int getRarityId() {
        return rarityId;
    }

    public void setRarityId(int rarityId) {
        this.rarityId = rarityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clazz clazz = (Clazz) o;
        return id == clazz.id && weaponClass == clazz.weaponClass && uniqueStat == clazz.uniqueStat && rarityId == clazz.rarityId && Objects.equals(name, clazz.name) && Objects.equals(shortcut, clazz.shortcut);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, weaponClass, uniqueStat, shortcut, rarityId);
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
    public WeaponClass getWeaponClassByWeaponClass() {
        return weaponClassByWeaponClass;
    }

    public void setWeaponClassByWeaponClass(WeaponClass weaponClassByWeaponClass) {
        this.weaponClassByWeaponClass = weaponClassByWeaponClass;
    }

    @ManyToOne
    @JoinColumn(name = "Rarity_id", referencedColumnName = "id", nullable = false)
    public Rarity getRarityByRarityId() {
        return rarityByRarityId;
    }

    public void setRarityByRarityId(Rarity rarityByRarityId) {
        this.rarityByRarityId = rarityByRarityId;
    }

    @OneToMany(mappedBy = "clazzByClassId")
    public Collection<MaterialClass> getMaterialClassesById() {
        return materialClassesById;
    }

    public void setMaterialClassesById(Collection<MaterialClass> materialClassesById) {
        this.materialClassesById = materialClassesById;
    }

    @OneToMany(mappedBy = "clazzByClassId")
    public Collection<StatClass> getStatClassesById() {
        return statClassesById;
    }

    public void setStatClassesById(Collection<StatClass> statClassesById) {
        this.statClassesById = statClassesById;
    }
}
