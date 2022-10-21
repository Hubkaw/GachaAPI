package com.gachaapi.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@IdClass(MaterialClassPK.class)
public class MaterialClass {
    private int materialId;
    private int classId;
    private int baseAmount;
    private int perLvlAmount;
    private Material materialByMaterialId;
    private Clazz clazzByClassId;

    @Id
    @Column(name = "Material_Id", nullable = false)
    public int getMaterialId() {
        return materialId;
    }

    public void setMaterialId(int materialId) {
        this.materialId = materialId;
    }

    @Id
    @Column(name = "Class_id", nullable = false)
    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
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
        MaterialClass that = (MaterialClass) o;
        return materialId == that.materialId && classId == that.classId && baseAmount == that.baseAmount && perLvlAmount == that.perLvlAmount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(materialId, classId, baseAmount, perLvlAmount);
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
    @JoinColumn(name = "Class_id", referencedColumnName = "id", nullable = false)
    public Clazz getClazzByClassId() {
        return clazzByClassId;
    }

    public void setClazzByClassId(Clazz clazzByClassId) {
        this.clazzByClassId = clazzByClassId;
    }
}
