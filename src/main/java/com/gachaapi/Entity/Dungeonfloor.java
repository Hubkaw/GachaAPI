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

    @OneToMany(mappedBy = "dungeonFloor")
    private Collection<ArtefactReward> artefactRewards;

    @ManyToOne
    @JoinColumn(name = "Dungeon_ID", referencedColumnName = "ID", nullable = false)
    @JsonIgnore
    private Dungeon dungeon;

    @OneToMany(mappedBy = "dungeonFloor")
    @JsonIgnore
    private Collection<MaterialReward> materialRewards;

    @ManyToOne
    @JoinColumn(name = "partyId", referencedColumnName = "Id", nullable = false)
    private Party party;

    @OneToMany(mappedBy = "dungeonfloor")
    @JsonIgnore
    private Collection<PlayerDungeonfloor> playerDungeonfloors;

    @OneToMany(mappedBy = "dungeonFloor")
    private Collection<WeaponReward> weaponRewards;

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
