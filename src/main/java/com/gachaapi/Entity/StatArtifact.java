package com.gachaapi.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "stat_artifact", schema = "gacha", catalog = "")
public class StatArtifact {
    private int id;
    private int value;
    private Statistic stats;
    @JsonIgnore
    private Artefact artefactByArtefactId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
        StatArtifact that = (StatArtifact) o;
        return id == that.id && value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value);
    }

    @ManyToOne
    @JoinColumn(name = "Statistic_Stat_id", referencedColumnName = "Stat_id", nullable = false)
    public Statistic getStats() {
        return stats;
    }

    public void setStats(Statistic statisticByStatisticStatId) {
        this.stats = statisticByStatisticStatId;
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
