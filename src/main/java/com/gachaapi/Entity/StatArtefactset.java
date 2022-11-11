package com.gachaapi.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "stat_artefactset", schema = "gacha", catalog = "")
public class StatArtefactset {
    private int id;
    private int value;
    private Set setBySetId;
    private Statistic statisticByStatisticStatId;

    @Id
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
        StatArtefactset that = (StatArtefactset) o;
        return id == that.id && value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value);
    }

    @ManyToOne
    @JoinColumn(name = "Set_Id", referencedColumnName = "Id", nullable = false)
    public Set getSetBySetId() {
        return setBySetId;
    }

    public void setSetBySetId(Set setBySetId) {
        this.setBySetId = setBySetId;
    }

    @ManyToOne
    @JoinColumn(name = "Statistic_Stat_id", referencedColumnName = "Stat_id", nullable = false)
    public Statistic getStatisticByStatisticStatId() {
        return statisticByStatisticStatId;
    }

    public void setStatisticByStatisticStatId(Statistic statisticByStatisticStatId) {
        this.statisticByStatisticStatId = statisticByStatisticStatId;
    }
}
