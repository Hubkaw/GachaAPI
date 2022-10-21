package com.gachaapi.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Party_DungeonFloor", schema = "dbo", catalog = "gacha")
@IdClass(PartyDungeonFloorPK.class)
public class PartyDungeonFloor {
    private int partyId;
    private int dungeonFloorId;
    private Party partyByPartyId;
    private DungeonFloor dungeonFloorByDungeonFloorId;

    @Id
    @Column(name = "Party_Id", nullable = false)
    public int getPartyId() {
        return partyId;
    }

    public void setPartyId(int partyId) {
        this.partyId = partyId;
    }

    @Id
    @Column(name = "DungeonFloor_ID", nullable = false)
    public int getDungeonFloorId() {
        return dungeonFloorId;
    }

    public void setDungeonFloorId(int dungeonFloorId) {
        this.dungeonFloorId = dungeonFloorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PartyDungeonFloor that = (PartyDungeonFloor) o;
        return partyId == that.partyId && dungeonFloorId == that.dungeonFloorId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(partyId, dungeonFloorId);
    }

    @ManyToOne
    @JoinColumn(name = "Party_Id", referencedColumnName = "Id", nullable = false)
    public Party getPartyByPartyId() {
        return partyByPartyId;
    }

    public void setPartyByPartyId(Party partyByPartyId) {
        this.partyByPartyId = partyByPartyId;
    }

    @ManyToOne
    @JoinColumn(name = "DungeonFloor_ID", referencedColumnName = "ID", nullable = false)
    public DungeonFloor getDungeonFloorByDungeonFloorId() {
        return dungeonFloorByDungeonFloorId;
    }

    public void setDungeonFloorByDungeonFloorId(DungeonFloor dungeonFloorByDungeonFloorId) {
        this.dungeonFloorByDungeonFloorId = dungeonFloorByDungeonFloorId;
    }
}
