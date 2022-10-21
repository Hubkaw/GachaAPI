package com.gachaapi.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@IdClass(MaterialWeaponClassPK.class)
public class MaterialWeaponClass {
    private int materialId;
    private int weaponClassId;
    private int baseAmount;
    private int perLvlAmount;
    private Material materialByMaterialId;
    private WeaponClass weaponClassByWeaponClassId;

    @Id
    @Column(name = "Material_Id", nullable = false)
    public int getMaterialId() {
        return materialId;
    }

    public void setMaterialId(int materialId) {
        this.materialId = materialId;
    }

    @Id
    @Column(name = "WeaponClass_Id", nullable = false)
    public int getWeaponClassId() {
        return weaponClassId;
    }

    public void setWeaponClassId(int weaponClassId) {
        this.weaponClassId = weaponClassId;
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
        MaterialWeaponClass that = (MaterialWeaponClass) o;
        return materialId == that.materialId && weaponClassId == that.weaponClassId && baseAmount == that.baseAmount && perLvlAmount == that.perLvlAmount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(materialId, weaponClassId, baseAmount, perLvlAmount);
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
    @JoinColumn(name = "WeaponClass_Id", referencedColumnName = "Id", nullable = false)
    public WeaponClass getWeaponClassByWeaponClassId() {
        return weaponClassByWeaponClassId;
    }

    public void setWeaponClassByWeaponClassId(WeaponClass weaponClassByWeaponClassId) {
        this.weaponClassByWeaponClassId = weaponClassByWeaponClassId;
    }
}
