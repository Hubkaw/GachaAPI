package com.gachaapi.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@IdClass(MaterialAffilationPK.class)
public class MaterialAffilation {
    private int materialId;
    private int affilationId;
    private int baseAmount;
    private int perLvlAmount;
    private Material materialByMaterialId;
    private Affilation affilationByAffilationId;

    @Id
    @Column(name = "Material_Id", nullable = false)
    public int getMaterialId() {
        return materialId;
    }

    public void setMaterialId(int materialId) {
        this.materialId = materialId;
    }

    @Id
    @Column(name = "Affilation_id", nullable = false)
    public int getAffilationId() {
        return affilationId;
    }

    public void setAffilationId(int affilationId) {
        this.affilationId = affilationId;
    }

    @Basic
    @Column(name = "BaseAmount", nullable = false)
    public int getBaseAmount() {
        return baseAmount;
    }

    public void setBaseAmount(int baseAmount) {
        this.baseAmount = baseAmount;
    }

    @Basic
    @Column(name = "PerLvlAmount", nullable = false)
    public int getPerLvlAmount() {
        return perLvlAmount;
    }

    public void setPerLvlAmount(int perLvlAmount) {
        this.perLvlAmount = perLvlAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MaterialAffilation that = (MaterialAffilation) o;
        return materialId == that.materialId && affilationId == that.affilationId && baseAmount == that.baseAmount && perLvlAmount == that.perLvlAmount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(materialId, affilationId, baseAmount, perLvlAmount);
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
    @JoinColumn(name = "Affilation_id", referencedColumnName = "id", nullable = false)
    public Affilation getAffilationByAffilationId() {
        return affilationByAffilationId;
    }

    public void setAffilationByAffilationId(Affilation affilationByAffilationId) {
        this.affilationByAffilationId = affilationByAffilationId;
    }
}
