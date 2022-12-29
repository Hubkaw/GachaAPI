package com.gachaapi.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gachaapi.Utils.AbilityType;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Ability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Basic
    @Column(name = "potency", nullable = false)
    private int potency;

    @Basic
    @Column(name = "name", nullable = false, length = 32)
    private String name;

    @Basic
    @Column(name = "type", nullable = false)
    private AbilityType type;

    @OneToMany(mappedBy = "ability")
    @JsonIgnore
    private List<Character> characters;

    @ManyToOne
    @JoinColumn(name = "Stat_id", referencedColumnName = "Stat_id", nullable = true)
    private Statistic stat;
}
