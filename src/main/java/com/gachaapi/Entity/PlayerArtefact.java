package com.gachaapi.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@Table(name = "player_artefact", schema = "gacha", catalog = "")
public class PlayerArtefact {

    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Basic
    @Column(name = "Lvl", nullable = false)
    private int lvl;


    @ManyToMany(cascade = {
            CascadeType.ALL
    })
    @JoinTable(name = "characteratrefact" ,
            joinColumns = {
                    @JoinColumn(name = "PlayerArtefact_Id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "PlayerCharacter_Id")
            })
    private Set<PlayerCharacter> playerCharacters;

    @ManyToOne
    @JoinColumn(name = "Player_IdPlayer", referencedColumnName = "IdPlayer", nullable = false)
    private Player playerByPlayerIdPlayer;

    @ManyToOne
    @JoinColumn(name = "Artefact_Id", referencedColumnName = "Id", nullable = false)
    private Artefact artefactByArtefactId;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerArtefact that = (PlayerArtefact) o;
        return id == that.id && lvl == that.lvl;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lvl);
    }
}
