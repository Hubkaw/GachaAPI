package com.gachaapi.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Materialelement {
    private int id;
    private int baseAmount;
    private int perLvlAmount;
    private Material material;
    @JsonIgnore
    private Element element;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        Materialelement that = (Materialelement) o;
        return id == that.id && baseAmount == that.baseAmount && perLvlAmount == that.perLvlAmount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, baseAmount, perLvlAmount);
    }

    @ManyToOne
    @JoinColumn(name = "Material_Id", referencedColumnName = "Id", nullable = false)
    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material materialByMaterialId) {
        this.material = materialByMaterialId;
    }

    @ManyToOne
    @JoinColumn(name = "Element_id", referencedColumnName = "id", nullable = false)
    public Element getElement() {
        return element;
    }

    public void setElement(Element elementByElementId) {
        this.element = elementByElementId;
    }
}
