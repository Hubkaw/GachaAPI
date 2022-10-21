package com.gachaapi.Model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class PartyCharacterPK implements Serializable {
    private int partyId;
    private int playerCharacterId;

    @Column(name = "Party_Id", nullable = false)
    @Id
    public int getPartyId() {
        return partyId;
    }

    public void setPartyId(int partyId) {
        this.partyId = partyId;
    }

    @Column(name = "PlayerCharacter_Id", nullable = false)
    @Id
    public int getPlayerCharacterId() {
        return playerCharacterId;
    }

    public void setPlayerCharacterId(int playerCharacterId) {
        this.playerCharacterId = playerCharacterId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PartyCharacterPK that = (PartyCharacterPK) o;
        return partyId == that.partyId && playerCharacterId == that.playerCharacterId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(partyId, playerCharacterId);
    }
}
