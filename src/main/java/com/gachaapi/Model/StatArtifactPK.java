package com.gachaapi.Model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class StatArtifactPK implements Serializable {
    private int statisticStatId;
    private int artefactId;

    @Column(name = "Statistic_Stat_id", nullable = false)
    @Id
    public int getStatisticStatId() {
        return statisticStatId;
    }

    public void setStatisticStatId(int statisticStatId) {
        this.statisticStatId = statisticStatId;
    }

    @Column(name = "Artefact_Id", nullable = false)
    @Id
    public int getArtefactId() {
        return artefactId;
    }

    public void setArtefactId(int artefactId) {
        this.artefactId = artefactId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatArtifactPK that = (StatArtifactPK) o;
        return statisticStatId == that.statisticStatId && artefactId == that.artefactId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(statisticStatId, artefactId);
    }
}
