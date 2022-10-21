package com.gachaapi.Model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class WeaponChestPK implements Serializable {
    private int weaponId;
    private int chestIdChest;

    @Column(name = "Weapon_Id", nullable = false)
    @Id
    public int getWeaponId() {
        return weaponId;
    }

    public void setWeaponId(int weaponId) {
        this.weaponId = weaponId;
    }

    @Column(name = "Chest_IdChest", nullable = false)
    @Id
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
        WeaponChestPK that = (WeaponChestPK) o;
        return weaponId == that.weaponId && chestIdChest == that.chestIdChest;
    }

    @Override
    public int hashCode() {
        return Objects.hash(weaponId, chestIdChest);
    }
}
