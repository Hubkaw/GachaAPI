package com.gachaapi.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Stat_artifact", schema = "dbo", catalog = "gacha")
@IdClass(StatArtifactPK.class)
public class StatArtifact {
    private int statisticStatId;
    private int artefactId;
    private Statistic statisticByStatisticStatId;
    private Artefact artefactByArtefactId;

    @Id
    @Column(name = "Statistic_Stat_id", nullable = false)
    public int getStatisticStatId() {
        return statisticStatId;
    }

    public void setStatisticStatId(int statisticStatId) {
        this.statisticStatId = statisticStatId;
    }

    @Id
    @Column(name = "Artefact_Id", nullable = false)
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
        StatArtifact that = (StatArtifact) o;
        return statisticStatId == that.statisticStatId && artefactId == that.artefactId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(statisticStatId, artefactId);
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
    @JoinColumn(name = "Artefact_Id", referencedColumnName = "Id", nullable = false)
    public Artefact getArtefactByArtefactId() {
        return artefactByArtefactId;
    }

    public void setArtefactByArtefactId(Artefact artefactByArtefactId) {
        this.artefactByArtefactId = artefactByArtefactId;
    }
}
