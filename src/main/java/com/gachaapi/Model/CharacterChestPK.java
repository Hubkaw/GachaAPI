package com.gachaapi.Model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class CharacterChestPK implements Serializable {
    private int characterId;
    private int chestIdChest;

    @Column(name = "Character_Id", nullable = false)
    @Id
    public int getCharacterId() {
        return characterId;
    }

    public void setCharacterId(int characterId) {
        this.characterId = characterId;
    }

    @Column(name = "Chest_IdChest", nullable = false)
    @Id
    public int getChestIdChest() {
        return chestIdChest;
    }

    public void setChestIdChest(int chestIdChest) {
        this.chestIdChest = chestIdChest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CharacterChestPK that = (CharacterChestPK) o;
        return characterId == that.characterId && chestIdChest == that.chestIdChest;
    }

    @Override
    public int hashCode() {
        return Objects.hash(characterId, chestIdChest);
    }
}
