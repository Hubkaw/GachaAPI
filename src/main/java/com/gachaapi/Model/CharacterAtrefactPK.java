package com.gachaapi.Model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class CharacterAtrefactPK implements Serializable {
    private int playerArtefactId;
    private int playerCharacterId;

    @Column(name = "PlayerArtefact_id", nullable = false)
    @Id
    public int getPlayerArtefactId() {
        return playerArtefactId;
    }

    public void setPlayerArtefactId(int playerArtefactId) {
        this.playerArtefactId = playerArtefactId;
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
        CharacterAtrefactPK that = (CharacterAtrefactPK) o;
        return playerArtefactId == that.playerArtefactId && playerCharacterId == that.playerCharacterId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerArtefactId, playerCharacterId);
    }
}
