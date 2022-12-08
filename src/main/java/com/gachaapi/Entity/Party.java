package com.gachaapi.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
public class Party {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private int id;

    @Basic
    @Column(name = "Name", nullable = false, length = 32)
    private String name;

    @Basic
    @Column(name = "MoveOrder", nullable = false)
    private long moveOrder;

    @ManyToOne
    @JoinColumn(name = "Player_IdPlayer", referencedColumnName = "IdPlayer", nullable = false)
    @JsonIgnore
    private Player playerByPlayerIdPlayer;

    @ManyToMany(cascade = {
            CascadeType.ALL
    })
    @JoinTable(name = "party_dungeonfloor" ,
            joinColumns = {
                    @JoinColumn(name = "Party_Id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "DungeonFloor_ID")
            })
    @JsonIgnore
    private Set<Dungeonfloor> dungeonFloors;

    @ManyToMany(cascade = {
            CascadeType.ALL
    })
    @JoinTable(name = "partycharacter" ,
    joinColumns = {
            @JoinColumn(name = "Party_Id")
    },
            inverseJoinColumns = {
            @JoinColumn(name = "PlayerCharacter_Id")
    })
    private Set<Character> characters;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Party party = (Party) o;
        return id == party.id && name == party.name && moveOrder == party.moveOrder;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, moveOrder);
    }

    @Override
    public String toString(){
        return  "party "+id;
    }
}
