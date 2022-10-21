package com.gachaapi.Model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class MaterialAffilationPK implements Serializable {
    private int materialId;
    private int affilationId;

    @Column(name = "Material_Id", nullable = false)
    @Id
    public int getMaterialId() {
        return materialId;
    }

    public void setMaterialId(int materialId) {
        this.materialId = materialId;
    }

    @Column(name = "Affilation_id", nullable = false)
    @Id
    public int getAffilationId() {
        return affilationId;
    }

    public void setAffilationId(int affilationId) {
        this.affilationId = affilationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MaterialAffilationPK that = (MaterialAffilationPK) o;
        return materialId == that.materialId && affilationId == that.affilationId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(materialId, affilationId);
    }
}
