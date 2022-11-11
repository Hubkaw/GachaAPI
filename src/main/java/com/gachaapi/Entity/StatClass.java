package com.gachaapi.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "stat_class", schema = "gacha", catalog = "")
public class StatClass {
    private int id;
    private int value;
    private Statistic statisticByStatisticStatId;
    private Clazz clazzByClassId;

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
        StatClass statClass = (StatClass) o;
        return id == statClass.id && value == statClass.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value);
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
    @JoinColumn(name = "Class_id", referencedColumnName = "id", nullable = false)
    public Clazz getClazzByClassId() {
        return clazzByClassId;
    }

    public void setClazzByClassId(Clazz clazzByClassId) {
        this.clazzByClassId = clazzByClassId;
    }
}
