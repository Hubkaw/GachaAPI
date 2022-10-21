package com.gachaapi.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Chest_Reward", schema = "dbo", catalog = "gacha")
@IdClass(ChestRewardPK.class)
public class ChestReward {
    private int chestIdChest;
    private int rewardId;
    private Chest chestByChestIdChest;
    private Reward rewardByRewardId;

    @Id
    @Column(name = "Chest_IdChest", nullable = false)
    public int getChestIdChest() {
        return chestIdChest;
    }

    public void setChestIdChest(int chestIdChest) {
        this.chestIdChest = chestIdChest;
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
        ChestReward that = (ChestReward) o;
        return chestIdChest == that.chestIdChest && rewardId == that.rewardId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(chestIdChest, rewardId);
    }

    @ManyToOne
    @JoinColumn(name = "Chest_IdChest", referencedColumnName = "IdChest", nullable = false)
    public Chest getChestByChestIdChest() {
        return chestByChestIdChest;
    }

    public void setChestByChestIdChest(Chest chestByChestIdChest) {
        this.chestByChestIdChest = chestByChestIdChest;
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
