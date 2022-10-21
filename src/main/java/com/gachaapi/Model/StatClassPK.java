package com.gachaapi.Model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class StatClassPK implements Serializable {
    private int statisticStatId;
    private int classId;

    @Column(name = "Statistic_Stat_id", nullable = false)
    @Id
    public int getStatisticStatId() {
        return statisticStatId;
    }

    public void setStatisticStatId(int statisticStatId) {
        this.statisticStatId = statisticStatId;
    }

    @Column(name = "Class_id", nullable = false)
    @Id
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
        StatClassPK that = (StatClassPK) o;
        return statisticStatId == that.statisticStatId && classId == that.classId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(statisticStatId, classId);
    }
}
