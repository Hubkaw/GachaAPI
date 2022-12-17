package com.gachaapi.Entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
public class PremiumPurchase {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @Column(name = "BoughtAt", nullable = false)
    private Timestamp boughtAt;

    @Basic
    @Column(name = "Days", nullable = false)
    private int days;

    @ManyToOne
    @JoinColumn(name = "IdPlayer", referencedColumnName = "IdPlayer", nullable = false)
    private Player player;

}
