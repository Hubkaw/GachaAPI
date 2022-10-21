package com.gachaapi.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@IdClass(MaterialElementPK.class)
public class MaterialElement {
    private int materialId;
    private int elementId;
    private int baseAmount;
    private int perLvlAmount;
    private Material materialByMaterialId;
    private Element elementByElementId;

    @Id
    @Column(name = "Material_Id", nullable = false)
    public int getMaterialId() {
        return materialId;
    }

    public void setMaterialId(int materialId) {
        this.materialId = materialId;
    }

    @Id
    @Column(name = "Element_id", nullable = false)
    public int getElementId() {
        return elementId;
    }

    public void setElementId(int elementId) {
        this.elementId = elementId;
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
        MaterialElement that = (MaterialElement) o;
        return materialId == that.materialId && elementId == that.elementId && baseAmount == that.baseAmount && perLvlAmount == that.perLvlAmount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(materialId, elementId, baseAmount, perLvlAmount);
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
    @JoinColumn(name = "Element_id", referencedColumnName = "id", nullable = false)
    public Element getElementByElementId() {
        return elementByElementId;
    }

    public void setElementByElementId(Element elementByElementId) {
        this.elementByElementId = elementByElementId;
    }
}
