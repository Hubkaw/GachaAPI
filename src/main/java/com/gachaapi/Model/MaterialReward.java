package com.gachaapi.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Material_Reward", schema = "dbo", catalog = "gacha")
@IdClass(MaterialRewardPK.class)
public class MaterialReward {
    private int materialId;
    private int rewardId;
    private Material materialByMaterialId;
    private Reward rewardByRewardId;

    @Id
    @Column(name = "Material_Id", nullable = false)
    public int getMaterialId() {
        return materialId;
    }

    public void setMaterialId(int materialId) {
        this.materialId = materialId;
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
        MaterialReward that = (MaterialReward) o;
        return materialId == that.materialId && rewardId == that.rewardId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(materialId, rewardId);
    }

    @ManyToOne
    @JoinColumn(name = "Material_Id", referencedColumnName = "Id", nullable = false)
    public Material getMaterialByMaterialId() {
        return materialByMaterialId;
    }

    public void setMaterialByMaterialId(Material materialByMaterialId) {
        this.materialByMaterialId = materialByMaterialId;
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
