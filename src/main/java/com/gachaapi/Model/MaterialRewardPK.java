package com.gachaapi.Model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class MaterialRewardPK implements Serializable {
    private int materialId;
    private int rewardId;

    @Column(name = "Material_Id", nullable = false)
    @Id
    public int getMaterialId() {
        return materialId;
    }

    public void setMaterialId(int materialId) {
        this.materialId = materialId;
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
        MaterialRewardPK that = (MaterialRewardPK) o;
        return materialId == that.materialId && rewardId == that.rewardId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(materialId, rewardId);
    }
}
