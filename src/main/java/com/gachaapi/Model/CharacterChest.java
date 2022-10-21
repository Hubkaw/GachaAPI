package com.gachaapi.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Character_Chest", schema = "dbo", catalog = "gacha")
@IdClass(CharacterChestPK.class)
public class CharacterChest {
    private int characterId;
    private int chestIdChest;
    private Character characterByCharacterId;
    private Chest chestByChestIdChest;

    @Id
    @Column(name = "Character_Id", nullable = false)
    public int getCharacterId() {
        return characterId;
    }

    public void setCharacterId(int characterId) {
        this.characterId = characterId;
    }

    @Id
    @Column(name = "Chest_IdChest", nullable = false)
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
        CharacterChest that = (CharacterChest) o;
        return characterId == that.characterId && chestIdChest == that.chestIdChest;
    }

    @Override
    public int hashCode() {
        return Objects.hash(characterId, chestIdChest);
    }

    @ManyToOne
    @JoinColumn(name = "Character_Id", referencedColumnName = "Id", nullable = false)
    public Character getCharacterByCharacterId() {
        return characterByCharacterId;
    }

    public void setCharacterByCharacterId(Character characterByCharacterId) {
        this.characterByCharacterId = characterByCharacterId;
    }

    @ManyToOne
    @JoinColumn(name = "Chest_IdChest", referencedColumnName = "IdChest", nullable = false)
    public Chest getChestByChestIdChest() {
        return chestByChestIdChest;
    }

    public void setChestByChestIdChest(Chest chestByChestIdChest) {
        this.chestByChestIdChest = chestByChestIdChest;
    }
}
