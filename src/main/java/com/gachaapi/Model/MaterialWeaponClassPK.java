package com.gachaapi.Model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class MaterialWeaponClassPK implements Serializable {
    private int materialId;
    private int weaponClassId;

    @Column(name = "Material_Id", nullable = false)
    @Id
    public int getMaterialId() {
        return materialId;
    }

    public void setMaterialId(int materialId) {
        this.materialId = materialId;
    }

    @Column(name = "WeaponClass_Id", nullable = false)
    @Id
    public int getWeaponClassId() {
        return weaponClassId;
    }

    public void setWeaponClassId(int weaponClassId) {
        this.weaponClassId = weaponClassId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MaterialWeaponClassPK that = (MaterialWeaponClassPK) o;
        return materialId == that.materialId && weaponClassId == that.weaponClassId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(materialId, weaponClassId);
    }
}
