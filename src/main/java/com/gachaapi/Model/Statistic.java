package com.gachaapi.Model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Statistic {
    private int statId;
    private String name;
    private BigDecimal value;
    private Collection<StatArtifact> statArtifactsByStatId;
    private Collection<StatClass> statClassesByStatId;
    private Collection<StatWeapon> statWeaponsByStatId;

    @Id
    @Column(name = "Stat_id", nullable = false)
    public int getStatId() {
        return statId;
    }

    public void setStatId(int statId) {
        this.statId = statId;
    }

    @Basic
    @Column(name = "Name", nullable = false, length = 32)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "value", nullable = false, precision = 2)
    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Statistic statistic = (Statistic) o;
        return statId == statistic.statId && Objects.equals(name, statistic.name) && Objects.equals(value, statistic.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statId, name, value);
    }

    @OneToMany(mappedBy = "statisticByStatisticStatId")
    public Collection<StatArtifact> getStatArtifactsByStatId() {
        return statArtifactsByStatId;
    }

    public void setStatArtifactsByStatId(Collection<StatArtifact> statArtifactsByStatId) {
        this.statArtifactsByStatId = statArtifactsByStatId;
    }

    @OneToMany(mappedBy = "statisticByStatisticStatId")
    public Collection<StatClass> getStatClassesByStatId() {
        return statClassesByStatId;
    }

    public void setStatClassesByStatId(Collection<StatClass> statClassesByStatId) {
        this.statClassesByStatId = statClassesByStatId;
    }

    @OneToMany(mappedBy = "statisticByStatisticStatId")
    public Collection<StatWeapon> getStatWeaponsByStatId() {
        return statWeaponsByStatId;
    }

    public void setStatWeaponsByStatId(Collection<StatWeapon> statWeaponsByStatId) {
        this.statWeaponsByStatId = statWeaponsByStatId;
    }
}
