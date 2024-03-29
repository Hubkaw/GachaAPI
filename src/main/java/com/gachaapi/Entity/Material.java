package com.gachaapi.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gachaapi.Utils.PvERewardInterface;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Material implements PvERewardInterface {
    private int id;
    private String name;
    @JsonIgnore
    private Collection<MaterialReward> materialRewardsById;
    @JsonIgnore
    private Collection<Materialaffilation> materialaffilationsById;
    @JsonIgnore
    private Collection<Materialclass> materialclassesById;
    @JsonIgnore
    private Collection<Materialelement> materialelementsById;
    @JsonIgnore
    private Collection<Materialweaponclass> materialweaponclassesById;
    @JsonIgnore
    private Collection<PlayerMaterial> playerMaterialsById;

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

    @OneToMany(mappedBy = "material")
    public Collection<MaterialReward> getMaterialRewardsById() {
        return materialRewardsById;
    }

    public void setMaterialRewardsById(Collection<MaterialReward> materialRewardsById) {
        this.materialRewardsById = materialRewardsById;
    }

    @OneToMany(mappedBy = "material")
    public Collection<Materialaffilation> getMaterialaffilationsById() {
        return materialaffilationsById;
    }

    public void setMaterialaffilationsById(Collection<Materialaffilation> materialaffilationsById) {
        this.materialaffilationsById = materialaffilationsById;
    }

    @OneToMany(mappedBy = "material")
    public Collection<Materialclass> getMaterialclassesById() {
        return materialclassesById;
    }

    public void setMaterialclassesById(Collection<Materialclass> materialclassesById) {
        this.materialclassesById = materialclassesById;
    }

    @OneToMany(mappedBy = "material")
    public Collection<Materialelement> getMaterialelementsById() {
        return materialelementsById;
    }

    public void setMaterialelementsById(Collection<Materialelement> materialelementsById) {
        this.materialelementsById = materialelementsById;
    }

    @OneToMany(mappedBy = "material")
    public Collection<Materialweaponclass> getMaterialweaponclassesById() {
        return materialweaponclassesById;
    }

    public void setMaterialweaponclassesById(Collection<Materialweaponclass> materialweaponclassesById) {
        this.materialweaponclassesById = materialweaponclassesById;
    }

    @OneToMany(mappedBy = "material")
    public Collection<PlayerMaterial> getPlayerMaterialsById() {
        return playerMaterialsById;
    }

    public void setPlayerMaterialsById(Collection<PlayerMaterial> playerMaterialsById) {
        this.playerMaterialsById = playerMaterialsById;
    }
}
