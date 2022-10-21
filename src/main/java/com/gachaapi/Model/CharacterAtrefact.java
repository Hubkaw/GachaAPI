package com.gachaapi.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@IdClass(CharacterAtrefactPK.class)
public class CharacterAtrefact {
    private int playerArtefactId;
    private int playerCharacterId;
    private PlayerArtefact playerArtefactByPlayerArtefactId;
    private PlayerCharacter playerCharacterByPlayerCharacterId;

    @Id
    @Column(name = "PlayerArtefact_id", nullable = false)
    public int getPlayerArtefactId() {
        return playerArtefactId;
    }

    public void setPlayerArtefactId(int playerArtefactId) {
        this.playerArtefactId = playerArtefactId;
    }

    @Id
    @Column(name = "PlayerCharacter_Id", nullable = false)
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
        CharacterAtrefact that = (CharacterAtrefact) o;
        return playerArtefactId == that.playerArtefactId && playerCharacterId == that.playerCharacterId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerArtefactId, playerCharacterId);
    }

    @ManyToOne
    @JoinColumn(name = "PlayerArtefact_id", referencedColumnName = "id", nullable = false)
    public PlayerArtefact getPlayerArtefactByPlayerArtefactId() {
        return playerArtefactByPlayerArtefactId;
    }

    public void setPlayerArtefactByPlayerArtefactId(PlayerArtefact playerArtefactByPlayerArtefactId) {
        this.playerArtefactByPlayerArtefactId = playerArtefactByPlayerArtefactId;
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
