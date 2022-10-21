package com.gachaapi.Model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@IdClass(PartyCharacterPK.class)
public class PartyCharacter {
    private int partyId;
    private int playerCharacterId;
    private int slot;
    private Collection<MoveOrder> moveOrders;
    private Party partyByPartyId;
    private PlayerCharacter playerCharacterByPlayerCharacterId;

    @Id
    @Column(name = "Party_Id", nullable = false)
    public int getPartyId() {
        return partyId;
    }

    public void setPartyId(int partyId) {
        this.partyId = partyId;
    }

    @Id
    @Column(name = "PlayerCharacter_Id", nullable = false)
    public int getPlayerCharacterId() {
        return playerCharacterId;
    }

    public void setPlayerCharacterId(int playerCharacterId) {
        this.playerCharacterId = playerCharacterId;
    }

    @Basic
    @Column(name = "slot", nullable = false)
    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PartyCharacter that = (PartyCharacter) o;
        return partyId == that.partyId && playerCharacterId == that.playerCharacterId && slot == that.slot;
    }

    @Override
    public int hashCode() {
        return Objects.hash(partyId, playerCharacterId, slot);
    }

    @OneToMany(mappedBy = "partyCharacter")
    public Collection<MoveOrder> getMoveOrders() {
        return moveOrders;
    }

    public void setMoveOrders(Collection<MoveOrder> moveOrders) {
        this.moveOrders = moveOrders;
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
    @JoinColumn(name = "PlayerCharacter_Id", referencedColumnName = "Id", nullable = false)
    public PlayerCharacter getPlayerCharacterByPlayerCharacterId() {
        return playerCharacterByPlayerCharacterId;
    }

    public void setPlayerCharacterByPlayerCharacterId(PlayerCharacter playerCharacterByPlayerCharacterId) {
        this.playerCharacterByPlayerCharacterId = playerCharacterByPlayerCharacterId;
    }
}
