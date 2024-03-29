package com.gachaapi.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@Table(name = "player_character", catalog = "")
public class PlayerCharacter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private int id;


    @Basic
    @Column(name = "Lvl", nullable = false)
    private int lvl;

    @ManyToMany(cascade = {
            CascadeType.ALL
    })
    @JoinTable(name = "characteratrefact" ,
            joinColumns = {
                    @JoinColumn(name = "PlayerCharacter_Id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "PlayerArtefact_Id")
            })
    private Set<PlayerArtefact> playerArtefacts;

    @ManyToMany(cascade = {
            CascadeType.ALL
    })
    @JoinTable(name = "partycharacter" ,
            joinColumns = {
                    @JoinColumn(name = "PlayerCharacter_Id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "Party_Id")
            })
    @JsonIgnore
    private Set<Party> parties;

    @ManyToOne
    @JoinColumn(name = "Player_IdPlayer", referencedColumnName = "IdPlayer", nullable = false)
    @JsonIgnore
    private Player player;

    @ManyToOne
    @JoinColumn(name = "Character_Id", referencedColumnName = "Id", nullable = false)
    private Character character;

    @OneToOne(optional = true, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "wieldedWeapon", referencedColumnName = "id")
    private PlayerWeapon wieldedWeapon;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerCharacter that = (PlayerCharacter) o;
        return id == that.id && lvl == that.lvl;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lvl);
    }
}
