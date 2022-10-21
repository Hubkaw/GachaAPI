package com.gachaapi.Model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class WeaponRewardPK implements Serializable {
    private int weaponId;
    private int rewardId;

    @Column(name = "Weapon_Id", nullable = false)
    @Id
    public int getWeaponId() {
        return weaponId;
    }

    public void setWeaponId(int weaponId) {
        this.weaponId = weaponId;
    }

    @Column(name = "Reward_ID", nullable = false)
    @Id
    public int getRewardId() {
        return rewardId;
    }

    public void setRewardId(int rewardId) {
        this.rewardId = rewardId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeaponRewardPK that = (WeaponRewardPK) o;
        return weaponId == that.weaponId && rewardId == that.rewardId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(weaponId, rewardId);
    }
}
