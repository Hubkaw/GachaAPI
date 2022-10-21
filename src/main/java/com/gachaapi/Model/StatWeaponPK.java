package com.gachaapi.Model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class StatWeaponPK implements Serializable {
    private int statisticStatId;
    private int weaponId;

    @Column(name = "Statistic_Stat_id", nullable = false)
    @Id
    public int getStatisticStatId() {
        return statisticStatId;
    }

    public void setStatisticStatId(int statisticStatId) {
        this.statisticStatId = statisticStatId;
    }

    @Column(name = "Weapon_Id", nullable = false)
    @Id
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
        StatWeaponPK that = (StatWeaponPK) o;
        return statisticStatId == that.statisticStatId && weaponId == that.weaponId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(statisticStatId, weaponId);
    }
}
