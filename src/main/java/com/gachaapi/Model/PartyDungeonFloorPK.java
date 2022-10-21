package com.gachaapi.Model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class PartyDungeonFloorPK implements Serializable {
    private int partyId;
    private int dungeonFloorId;

    @Column(name = "Party_Id", nullable = false)
    @Id
    public int getPartyId() {
        return partyId;
    }

    public void setPartyId(int partyId) {
        this.partyId = partyId;
    }

    @Column(name = "DungeonFloor_ID", nullable = false)
    @Id
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
        PartyDungeonFloorPK that = (PartyDungeonFloorPK) o;
        return partyId == that.partyId && dungeonFloorId == that.dungeonFloorId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(partyId, dungeonFloorId);
    }
}
