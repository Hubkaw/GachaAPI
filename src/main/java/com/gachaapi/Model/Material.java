package com.gachaapi.Model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Material {
    private int id;
    private String name;
    private Collection<MaterialAffilation> materialAffilationsById;
    private Collection<MaterialClass> materialClassesById;
    private Collection<MaterialElement> materialElementsById;
    private Collection<MaterialWeaponClass> materialWeaponClassesById;
    private Collection<MaterialReward> materialRewardsById;
    private Collection<PlayerMaterial> playerMaterialsById;

    @Id
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Name", nullable = false, length = 32)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Material material = (Material) o;
        return id == material.id && Objects.equals(name, material.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @OneToMany(mappedBy = "materialByMaterialId")
    public Collection<MaterialAffilation> getMaterialAffilationsById() {
        return materialAffilationsById;
    }

    public void setMaterialAffilationsById(Collection<MaterialAffilation> materialAffilationsById) {
        this.materialAffilationsById = materialAffilationsById;
    }

    @OneToMany(mappedBy = "materialByMaterialId")
    public Collection<MaterialClass> getMaterialClassesById() {
        return materialClassesById;
    }

    public void setMaterialClassesById(Collection<MaterialClass> materialClassesById) {
        this.materialClassesById = materialClassesById;
    }

    @OneToMany(mappedBy = "materialByMaterialId")
    public Collection<MaterialElement> getMaterialElementsById() {
        return materialElementsById;
    }

    public void setMaterialElementsById(Collection<MaterialElement> materialElementsById) {
        this.materialElementsById = materialElementsById;
    }

    @OneToMany(mappedBy = "materialByMaterialId")
    public Collection<MaterialWeaponClass> getMaterialWeaponClassesById() {
        return materialWeaponClassesById;
    }

    public void setMaterialWeaponClassesById(Collection<MaterialWeaponClass> materialWeaponClassesById) {
        this.materialWeaponClassesById = materialWeaponClassesById;
    }

    @OneToMany(mappedBy = "materialByMaterialId")
    public Collection<MaterialReward> getMaterialRewardsById() {
        return materialRewardsById;
    }

    public void setMaterialRewardsById(Collection<MaterialReward> materialRewardsById) {
        this.materialRewardsById = materialRewardsById;
    }

    @OneToMany(mappedBy = "materialByMaterialId")
    public Collection<PlayerMaterial> getPlayerMaterialsById() {
        return playerMaterialsById;
    }

    public void setPlayerMaterialsById(Collection<PlayerMaterial> playerMaterialsById) {
        this.playerMaterialsById = playerMaterialsById;
    }
}
