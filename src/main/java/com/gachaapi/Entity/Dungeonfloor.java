package com.gachaapi.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Data
@Entity
public class Dungeonfloor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private int id;

    @Basic
    @Column(name = "Depth", nullable = false)
    private int depth;

    @OneToMany(mappedBy = "dungeonfloorByDungeonFloorId")
    private Collection<ArtefactReward> artefactRewardsById;

    @ManyToOne
    @JoinColumn(name = "Dungeon_ID", referencedColumnName = "ID", nullable = false)
    @JsonIgnore
    private Dungeon dungeonByDungeonId;

    @OneToMany(mappedBy = "dungeonfloorByDungeonFloorId")
    @JsonIgnore
    private Collection<MaterialReward> materialRewardsById;

    @ManyToOne
    @JoinColumn(name = "partyId", referencedColumnName = "Id", nullable = false)
    private Party party;

    @OneToMany(mappedBy = "dungeonfloorByDungeonFloorId")
    @JsonIgnore
    private Collection<PlayerDungeonfloor> playerDungeonfloorsById;

    @OneToMany(mappedBy = "dungeonfloorByDungeonFloorId")
    private Collection<WeaponReward> weaponRewardsById;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dungeonfloor that = (Dungeonfloor) o;
        return id == that.id && depth == that.depth;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, depth);
    }
}
