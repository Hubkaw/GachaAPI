package com.gachaapi.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class MoveOrder {
    private int idMoveOrder;
    private int partyCharacterPartyId;
    private int partyCharacterPlayerCharacterId;
    private int order;
    private PartyCharacter partyCharacter;

    @Id
    @Column(name = "IdMoveOrder", nullable = false)
    public int getIdMoveOrder() {
        return idMoveOrder;
    }

    public void setIdMoveOrder(int idMoveOrder) {
        this.idMoveOrder = idMoveOrder;
    }

    @Basic
    @Column(name = "PartyCharacter_Party_Id", nullable = false)
    public int getPartyCharacterPartyId() {
        return partyCharacterPartyId;
    }

    public void setPartyCharacterPartyId(int partyCharacterPartyId) {
        this.partyCharacterPartyId = partyCharacterPartyId;
    }

    @Basic
    @Column(name = "PartyCharacter_PlayerCharacter_Id", nullable = false)
    public int getPartyCharacterPlayerCharacterId() {
        return partyCharacterPlayerCharacterId;
    }

    public void setPartyCharacterPlayerCharacterId(int partyCharacterPlayerCharacterId) {
        this.partyCharacterPlayerCharacterId = partyCharacterPlayerCharacterId;
    }

    @Basic
    @Column(name = "Order", nullable = false)
    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoveOrder moveOrder = (MoveOrder) o;
        return idMoveOrder == moveOrder.idMoveOrder && partyCharacterPartyId == moveOrder.partyCharacterPartyId && partyCharacterPlayerCharacterId == moveOrder.partyCharacterPlayerCharacterId && order == moveOrder.order;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMoveOrder, partyCharacterPartyId, partyCharacterPlayerCharacterId, order);
    }

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "PartyCharacter_Party_Id", referencedColumnName = "Party_Id", nullable = false), @JoinColumn(name = "PartyCharacter_PlayerCharacter_Id", referencedColumnName = "PlayerCharacter_Id", nullable = false)})
    public PartyCharacter getPartyCharacter() {
        return partyCharacter;
    }

    public void setPartyCharacter(PartyCharacter partyCharacter) {
        this.partyCharacter = partyCharacter;
    }
}
