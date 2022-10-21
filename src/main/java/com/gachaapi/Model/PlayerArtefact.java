package com.gachaapi.Model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Player_Artefact", schema = "dbo", catalog = "gacha")
public class PlayerArtefact {
    private int id;
    private int playerIdPlayer;
    private int artefactId;
    private int lvl;
    private Collection<CharacterAtrefact> characterAtrefactsById;
    private Player playerByPlayerIdPlayer;
    private Artefact artefactByArtefactId;

    @Id
    @Column(name = "id", nullable = false)
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
    @Column(name = "Artefact_Id", nullable = false)
    public int getArtefactId() {
        return artefactId;
    }

    public void setArtefactId(int artefactId) {
        this.artefactId = artefactId;
    }

    @Basic
    @Column(name = "Lvl", nullable = false)
    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerArtefact that = (PlayerArtefact) o;
        return id == that.id && playerIdPlayer == that.playerIdPlayer && artefactId == that.artefactId && lvl == that.lvl;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, playerIdPlayer, artefactId, lvl);
    }

    @OneToMany(mappedBy = "playerArtefactByPlayerArtefactId")
    public Collection<CharacterAtrefact> getCharacterAtrefactsById() {
        return characterAtrefactsById;
    }

    public void setCharacterAtrefactsById(Collection<CharacterAtrefact> characterAtrefactsById) {
        this.characterAtrefactsById = characterAtrefactsById;
    }

    @ManyToOne
    @JoinColumn(name = "Player_IdPlayer", referencedColumnName = "IdPlayer", nullable = false)
    public Player getPlayerByPlayerIdPlayer() {
        return playerByPlayerIdPlayer;
    }

    public void setPlayerByPlayerIdPlayer(Player playerByPlayerIdPlayer) {
        this.playerByPlayerIdPlayer = playerByPlayerIdPlayer;
    }

    @ManyToOne
    @JoinColumn(name = "Artefact_Id", referencedColumnName = "Id", nullable = false)
    public Artefact getArtefactByArtefactId() {
        return artefactByArtefactId;
    }

    public void setArtefactByArtefactId(Artefact artefactByArtefactId) {
        this.artefactByArtefactId = artefactByArtefactId;
    }
}
