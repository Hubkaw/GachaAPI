package com.gachaapi.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gachaapi.Battle.BattleLog;
import com.gachaapi.Utils.BattleType;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class BattleHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;


    @ManyToOne
    @JoinColumn(name = "attackerId", referencedColumnName = "IdPlayer", nullable = false)
    @JsonIgnore
    private Player attacker;

    @ManyToOne
    @JoinColumn(name = "defenderId", referencedColumnName = "IdPlayer", nullable = false)
    @JsonIgnore
    private Player defender;

    @Basic
    @Column(name = "log", nullable = false, length = 65535)
    private BattleLog log;

    @Basic
    @Column(name = "type", nullable = false)
    private BattleType type;
}

