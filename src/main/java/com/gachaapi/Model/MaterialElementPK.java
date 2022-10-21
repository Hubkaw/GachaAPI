package com.gachaapi.Model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class MaterialElementPK implements Serializable {
    private int materialId;
    private int elementId;

    @Column(name = "Material_Id", nullable = false)
    @Id
    public int getMaterialId() {
        return materialId;
    }

    public void setMaterialId(int materialId) {
        this.materialId = materialId;
    }

    @Column(name = "Element_id", nullable = false)
    @Id
    public int getElementId() {
        return elementId;
    }

    public void setElementId(int elementId) {
        this.elementId = elementId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MaterialElementPK that = (MaterialElementPK) o;
        return materialId == that.materialId && elementId == that.elementId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(materialId, elementId);
    }
}
