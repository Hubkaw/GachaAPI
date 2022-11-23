package com.gachaapi.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "stat_affiliation", schema = "gacha", catalog = "")
public class StatAffiliation {
    private int id;
    private int value;
    private Statistic statistic;
    private Affilation affiliation;

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
    public int hashCode() {
        return Objects.hash(id, value);
    }

    @ManyToOne
    @JoinColumn(name = "Statistic_Stat_id", referencedColumnName = "Stat_id", nullable = false)
    public Statistic getStatistic() {
        return statistic;
    }

    public void setStatistic(Statistic statisticByStatisticStatId) {
        this.statistic = statisticByStatisticStatId;
    }

    @ManyToOne
    @JoinColumn(name = "Affiliation_Id", referencedColumnName = "id", nullable = false)
    public Affilation getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(Affilation affiliation) {
        this.affiliation = affiliation;
    }
}
