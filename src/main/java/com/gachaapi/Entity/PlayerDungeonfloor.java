package com.gachaapi.Entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;

@Data
@Entity
@Table(name = "player_dungeonfloor", schema = "gacha", catalog = "")
public class PlayerDungeonfloor {

    @Id
    @Column(name = "Id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int Id;

    @ManyToOne
    @JoinColumn(name = "DungeonFloor_ID", referencedColumnName = "ID", nullable = false)
    private Dungeonfloor dungeonfloorByDungeonFloorId;

    @ManyToOne
    @JoinColumn(name = "Player_IdPlayer", referencedColumnName = "IdPlayer", nullable = false)
    private Player playerByPlayerIdPlayer;

    @Basic
    @Column(name = "clearDate", nullable = true)
    private Timestamp clearDate;

}
