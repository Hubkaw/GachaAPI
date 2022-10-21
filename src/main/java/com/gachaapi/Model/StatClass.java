package com.gachaapi.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Stat_class", schema = "dbo", catalog = "gacha")
@IdClass(StatClassPK.class)
public class StatClass {
    private int statisticStatId;
    private int classId;
    private Statistic statisticByStatisticStatId;
    private Clazz clazzByClassId;

    @Id
    @Column(name = "Statistic_Stat_id", nullable = false)
    public int getStatisticStatId() {
        return statisticStatId;
    }

    public void setStatisticStatId(int statisticStatId) {
        this.statisticStatId = statisticStatId;
    }

    @Id
    @Column(name = "Class_id", nullable = false)
    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatClass statClass = (StatClass) o;
        return statisticStatId == statClass.statisticStatId && classId == statClass.classId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(statisticStatId, classId);
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
