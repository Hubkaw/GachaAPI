package com.gachaapi.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Weapon_Reward", schema = "dbo", catalog = "gacha")
@IdClass(WeaponRewardPK.class)
public class WeaponReward {
    private int weaponId;
    private int rewardId;
    private Weapon weaponByWeaponId;
    private Reward rewardByRewardId;

    @Id
    @Column(name = "Weapon_Id", nullable = false)
    public int getWeaponId() {
        return weaponId;
    }

    public void setWeaponId(int weaponId) {
        this.weaponId = weaponId;
    }

    @Id
    @Column(name = "Reward_ID", nullable = false)
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
        WeaponReward that = (WeaponReward) o;
        return weaponId == that.weaponId && rewardId == that.rewardId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(weaponId, rewardId);
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
    @JoinColumn(name = "Reward_ID", referencedColumnName = "ID", nullable = false)
    public Reward getRewardByRewardId() {
        return rewardByRewardId;
    }

    public void setRewardByRewardId(Reward rewardByRewardId) {
        this.rewardByRewardId = rewardByRewardId;
    }
}
