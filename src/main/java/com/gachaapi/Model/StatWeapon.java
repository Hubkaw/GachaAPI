package com.gachaapi.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Stat_weapon", schema = "dbo", catalog = "gacha")
@IdClass(StatWeaponPK.class)
public class StatWeapon {
    private int statisticStatId;
    private int weaponId;
    private Statistic statisticByStatisticStatId;
    private Weapon weaponByWeaponId;

    @Id
    @Column(name = "Statistic_Stat_id", nullable = false)
    public int getStatisticStatId() {
        return statisticStatId;
    }

    public void setStatisticStatId(int statisticStatId) {
        this.statisticStatId = statisticStatId;
    }

    @Id
    @Column(name = "Weapon_Id", nullable = false)
    public int getWeaponId() {
        return weaponId;
    }

    public void setWeaponId(int weaponId) {
        this.weaponId = weaponId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatWeapon that = (StatWeapon) o;
        return statisticStatId == that.statisticStatId && weaponId == that.weaponId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(statisticStatId, weaponId);
    }

    @ManyToOne
    @JoinColumn(name = "Statistic_Stat_id", referencedColumnName = "Stat_id", nullable = false)
    public Statistic getStatisticByStatisticStatId() {
        return statisticByStatisticStatId;
    }

    public void setStatisticByStatisticStatId(Statistic statisticByStatisticStatId) {
        this.statisticByStatisticStatId = statisticByStatisticStatId;
    }

    @ManyToOne
    @JoinColumn(name = "Weapon_Id", referencedColumnName = "Id", nullable = false)
    public Weapon getWeaponByWeaponId() {
        return weaponByWeaponId;
    }

    public void setWeaponByWeaponId(Weapon weaponByWeaponId) {
        this.weaponByWeaponId = weaponByWeaponId;
    }
}
