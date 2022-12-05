package com.gachaapi.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Statistic {
    private int statId;
    private String name;
    private String shortName;
    @JsonIgnore
    private Collection<StatArtefactset> statArtefactsetsByStatId;
    @JsonIgnore
    private Collection<StatArtifact> statArtifactsByStatId;
    @JsonIgnore
    private Collection<StatClass> statClassesByStatId;
    @JsonIgnore
    private Collection<StatWeapon> statWeaponsByStatId;
    @JsonIgnore
    private Collection<StatAffiliation> statAffiliations;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Column(name = "shortName", nullable = false, length = 3)
    public String getShortName(){return shortName;}

    public void setShortName(String shortName){this.shortName = shortName;}
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Statistic statistic = (Statistic) o;
        return statId == statistic.statId && Objects.equals(name, statistic.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statId, name);
    }

    @OneToMany(mappedBy = "statisticByStatisticStatId")
    public Collection<StatArtefactset> getStatArtefactsetsByStatId() {
        return statArtefactsetsByStatId;
    }

    public void setStatArtefactsetsByStatId(Collection<StatArtefactset> statArtefactsetsByStatId) {
        this.statArtefactsetsByStatId = statArtefactsetsByStatId;
    }

    @OneToMany(mappedBy = "stats")
    public Collection<StatArtifact> getStatArtifactsByStatId() {
        return statArtifactsByStatId;
    }

    public void setStatArtifactsByStatId(Collection<StatArtifact> statArtifactsByStatId) {
        this.statArtifactsByStatId = statArtifactsByStatId;
    }

    @OneToMany(mappedBy = "stat")
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

    @OneToMany(mappedBy = "statistic")
    public Collection<StatAffiliation> getStatAffiliations() {
        return statAffiliations;
    }

    public void setStatAffiliations(Collection<StatAffiliation> statAffiliations) {
        this.statAffiliations = statAffiliations;
    }
}
