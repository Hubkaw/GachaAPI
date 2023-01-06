package com.gachaapi.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "stat_weapon", catalog = "")
public class StatWeapon {
    private int id;
    private int value;
    private Statistic stat;
    @JsonIgnore
    private Weapon weapon;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "value", nullable = false)
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatWeapon that = (StatWeapon) o;
        return id == that.id && value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value);
    }

    @ManyToOne
    @JoinColumn(name = "Statistic_Stat_id", referencedColumnName = "Stat_id", nullable = false)
    public Statistic getStat() {
        return stat;
    }

    public void setStat(Statistic statisticByStatisticStatId) {
        this.stat = statisticByStatisticStatId;
    }

    @ManyToOne
    @JoinColumn(name = "Weapon_Id", referencedColumnName = "Id", nullable = false)
    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weaponByWeaponId) {
        this.weapon = weaponByWeaponId;
    }
}
