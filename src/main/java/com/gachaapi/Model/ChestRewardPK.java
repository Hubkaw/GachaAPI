package com.gachaapi.Model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ChestRewardPK implements Serializable {
    private int chestIdChest;
    private int rewardId;

    @Column(name = "Chest_IdChest", nullable = false)
    @Id
    public int getChestIdChest() {
        return chestIdChest;
    }

    public void setChestIdChest(int chestIdChest) {
        this.chestIdChest = chestIdChest;
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
        ChestRewardPK that = (ChestRewardPK) o;
        return chestIdChest == that.chestIdChest && rewardId == that.rewardId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(chestIdChest, rewardId);
    }
}
