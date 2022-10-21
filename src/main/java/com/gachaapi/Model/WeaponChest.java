package com.gachaapi.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Weapon_Chest", schema = "dbo", catalog = "gacha")
@IdClass(WeaponChestPK.class)
public class WeaponChest {
    private int weaponId;
    private int chestIdChest;
    private Weapon weaponByWeaponId;
    private Chest chestByChestIdChest;

    @Id
    @Column(name = "Weapon_Id", nullable = false)
    public int getWeaponId() {
        return weaponId;
    }

    public void setWeaponId(int weaponId) {
        this.weaponId = weaponId;
    }

    @Id
    @Column(name = "Chest_IdChest", nullable = false)
    public int getChestIdChest() {
        return chestIdChest;
    }

    public void setChestIdChest(int chestIdChest) {
        this.chestIdChest = chestIdChest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeaponChest that = (WeaponChest) o;
        return weaponId == that.weaponId && chestIdChest == that.chestIdChest;
    }

    @Override
    public int hashCode() {
        return Objects.hash(weaponId, chestIdChest);
    }

    @ManyToOne
    @JoinColumn(name = "Weapon_Id", referencedColumnName = "Id", nullable = false)
    public Weapon getWeaponByWeaponId() {
        return weaponByWeaponId;
    }

    public void setWeaponByWeaponId(Weapon weaponByWeaponId) {
        this.weaponByWeaponId = weaponByWeaponId;
    }

    @ManyToOne
    @JoinColumn(name = "Chest_IdChest", referencedColumnName = "IdChest", nullable = false)
    public Chest getChestByChestIdChest() {
        return chestByChestIdChest;
    }

    public void setChestByChestIdChest(Chest chestByChestIdChest) {
        this.chestByChestIdChest = chestByChestIdChest;
    }
}
