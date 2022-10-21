package com.gachaapi.Model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Reward {
    private int id;
    private int quantity;
    private Collection<ChestReward> chestRewardsById;
    private Collection<Dungeon> dungeonsById;
    private Collection<DungeonFloor> dungeonFloorsById;
    private Collection<MaterialReward> materialRewardsById;
    private Collection<WeaponReward> weaponRewardsById;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Quantity", nullable = false)
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reward reward = (Reward) o;
        return id == reward.id && quantity == reward.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantity);
    }

    @OneToMany(mappedBy = "rewardByRewardId")
    public Collection<ChestReward> getChestRewardsById() {
        return chestRewardsById;
    }

    public void setChestRewardsById(Collection<ChestReward> chestRewardsById) {
        this.chestRewardsById = chestRewardsById;
    }

    @OneToMany(mappedBy = "rewardByRewardId")
    public Collection<Dungeon> getDungeonsById() {
        return dungeonsById;
    }

    public void setDungeonsById(Collection<Dungeon> dungeonsById) {
        this.dungeonsById = dungeonsById;
    }

    @OneToMany(mappedBy = "rewardByRewardId")
    public Collection<DungeonFloor> getDungeonFloorsById() {
        return dungeonFloorsById;
    }

    public void setDungeonFloorsById(Collection<DungeonFloor> dungeonFloorsById) {
        this.dungeonFloorsById = dungeonFloorsById;
    }

    @OneToMany(mappedBy = "rewardByRewardId")
    public Collection<MaterialReward> getMaterialRewardsById() {
        return materialRewardsById;
    }

    public void setMaterialRewardsById(Collection<MaterialReward> materialRewardsById) {
        this.materialRewardsById = materialRewardsById;
    }

    @OneToMany(mappedBy = "rewardByRewardId")
    public Collection<WeaponReward> getWeaponRewardsById() {
        return weaponRewardsById;
    }

    public void setWeaponRewardsById(Collection<WeaponReward> weaponRewardsById) {
        this.weaponRewardsById = weaponRewardsById;
    }
}
