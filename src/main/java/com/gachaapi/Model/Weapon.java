package com.gachaapi.Model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Weapon {
    private int id;
    private String name;
    private int elementId;
    private int rarityId;
    private int weaponClassId;
    private Collection<PlayerWeapon> playerWeaponsById;
    private Collection<StatWeapon> statWeaponsById;
    private Element elementByElementId;
    private Rarity rarityByRarityId;
    private WeaponClass weaponClassByWeaponClassId;
    private Collection<WeaponChest> weaponChestsById;
    private Collection<WeaponReward> weaponRewardsById;

    @Id
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Name", nullable = false, length = 64)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "Element_id", nullable = false)
    public int getElementId() {
        return elementId;
    }

    public void setElementId(int elementId) {
        this.elementId = elementId;
    }

    @Basic
    @Column(name = "Rarity_id", nullable = false)
    public int getRarityId() {
        return rarityId;
    }

    public void setRarityId(int rarityId) {
        this.rarityId = rarityId;
    }

    @Basic
    @Column(name = "WeaponClass_Id", nullable = false)
    public int getWeaponClassId() {
        return weaponClassId;
    }

    public void setWeaponClassId(int weaponClassId) {
        this.weaponClassId = weaponClassId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weapon weapon = (Weapon) o;
        return id == weapon.id && elementId == weapon.elementId && rarityId == weapon.rarityId && weaponClassId == weapon.weaponClassId && Objects.equals(name, weapon.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, elementId, rarityId, weaponClassId);
    }

    @OneToMany(mappedBy = "weaponByWeaponId")
    public Collection<PlayerWeapon> getPlayerWeaponsById() {
        return playerWeaponsById;
    }

    public void setPlayerWeaponsById(Collection<PlayerWeapon> playerWeaponsById) {
        this.playerWeaponsById = playerWeaponsById;
    }

    @OneToMany(mappedBy = "weaponByWeaponId")
    public Collection<StatWeapon> getStatWeaponsById() {
        return statWeaponsById;
    }

    public void setStatWeaponsById(Collection<StatWeapon> statWeaponsById) {
        this.statWeaponsById = statWeaponsById;
    }

    @ManyToOne
    @JoinColumn(name = "Element_id", referencedColumnName = "id", nullable = false)
    public Element getElementByElementId() {
        return elementByElementId;
    }

    public void setElementByElementId(Element elementByElementId) {
        this.elementByElementId = elementByElementId;
    }

    @ManyToOne
    @JoinColumn(name = "Rarity_id", referencedColumnName = "id", nullable = false)
    public Rarity getRarityByRarityId() {
        return rarityByRarityId;
    }

    public void setRarityByRarityId(Rarity rarityByRarityId) {
        this.rarityByRarityId = rarityByRarityId;
    }

    @ManyToOne
    @JoinColumn(name = "WeaponClass_Id", referencedColumnName = "Id", nullable = false)
    public WeaponClass getWeaponClassByWeaponClassId() {
        return weaponClassByWeaponClassId;
    }

    public void setWeaponClassByWeaponClassId(WeaponClass weaponClassByWeaponClassId) {
        this.weaponClassByWeaponClassId = weaponClassByWeaponClassId;
    }

    @OneToMany(mappedBy = "weaponByWeaponId")
    public Collection<WeaponChest> getWeaponChestsById() {
        return weaponChestsById;
    }

    public void setWeaponChestsById(Collection<WeaponChest> weaponChestsById) {
        this.weaponChestsById = weaponChestsById;
    }

    @OneToMany(mappedBy = "weaponByWeaponId")
    public Collection<WeaponReward> getWeaponRewardsById() {
        return weaponRewardsById;
    }

    public void setWeaponRewardsById(Collection<WeaponReward> weaponRewardsById) {
        this.weaponRewardsById = weaponRewardsById;
    }
}
