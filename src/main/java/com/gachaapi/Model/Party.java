package com.gachaapi.Model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Party {
    private int id;
    private int playerIdPlayer;
    private int slot;
    private int name;
    private Player playerByPlayerIdPlayer;
    private Collection<PartyCharacter> partyCharactersById;
    private Collection<PartyDungeonFloor> partyDungeonFloorsById;

    @Id
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Player_IdPlayer", nullable = false)
    public int getPlayerIdPlayer() {
        return playerIdPlayer;
    }

    public void setPlayerIdPlayer(int playerIdPlayer) {
        this.playerIdPlayer = playerIdPlayer;
    }

    @Basic
    @Column(name = "Slot", nullable = false)
    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    @Basic
    @Column(name = "Name", nullable = false)
    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Party party = (Party) o;
        return id == party.id && playerIdPlayer == party.playerIdPlayer && slot == party.slot && name == party.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, playerIdPlayer, slot, name);
    }

    @ManyToOne
    @JoinColumn(name = "Player_IdPlayer", referencedColumnName = "IdPlayer", nullable = false)
    public Player getPlayerByPlayerIdPlayer() {
        return playerByPlayerIdPlayer;
    }

    public void setPlayerByPlayerIdPlayer(Player playerByPlayerIdPlayer) {
        this.playerByPlayerIdPlayer = playerByPlayerIdPlayer;
    }

    @OneToMany(mappedBy = "partyByPartyId")
    public Collection<PartyCharacter> getPartyCharactersById() {
        return partyCharactersById;
    }

    public void setPartyCharactersById(Collection<PartyCharacter> partyCharactersById) {
        this.partyCharactersById = partyCharactersById;
    }

    @OneToMany(mappedBy = "partyByPartyId")
    public Collection<PartyDungeonFloor> getPartyDungeonFloorsById() {
        return partyDungeonFloorsById;
    }

    public void setPartyDungeonFloorsById(Collection<PartyDungeonFloor> partyDungeonFloorsById) {
        this.partyDungeonFloorsById = partyDungeonFloorsById;
    }
}
