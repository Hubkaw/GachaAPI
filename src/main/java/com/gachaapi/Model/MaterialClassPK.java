package com.gachaapi.Model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class MaterialClassPK implements Serializable {
    private int materialId;
    private int classId;

    @Column(name = "Material_Id", nullable = false)
    @Id
    public int getMaterialId() {
        return materialId;
    }

    public void setMaterialId(int materialId) {
        this.materialId = materialId;
    }

    @Column(name = "Class_id", nullable = false)
    @Id
    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MaterialClassPK that = (MaterialClassPK) o;
        return materialId == that.materialId && classId == that.classId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(materialId, classId);
    }
}
