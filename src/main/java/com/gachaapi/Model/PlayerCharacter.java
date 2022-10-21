package com.gachaapi.Model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Player_Character", schema = "dbo", catalog = "gacha")
public class PlayerCharacter {
    private int id;
    private int playerIdPlayer;
    private int characterId;
    private int ascention;
    private int lvl;
    private Collection<CharacterAtrefact> characterAtrefactsById;
    private Collection<PartyCharacter> partyCharactersById;
    private Player playerByPlayerIdPlayer;
    private Character characterByCharacterId;
    private Collection<PlayerWeapon> playerWeaponsById;

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
    @Column(name = "Character_Id", nullable = false)
    public int getCharacterId() {
        return characterId;
    }

    public void setCharacterId(int characterId) {
        this.characterId = characterId;
    }

    @Basic
    @Column(name = "Ascention", nullable = false)
    public int getAscention() {
        return ascention;
    }

    public void setAscention(int ascention) {
        this.ascention = ascention;
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
        PlayerCharacter that = (PlayerCharacter) o;
        return id == that.id && playerIdPlayer == that.playerIdPlayer && characterId == that.characterId && ascention == that.ascention && lvl == that.lvl;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, playerIdPlayer, characterId, ascention, lvl);
    }

    @OneToMany(mappedBy = "playerCharacterByPlayerCharacterId")
    public Collection<CharacterAtrefact> getCharacterAtrefactsById() {
        return characterAtrefactsById;
    }

    public void setCharacterAtrefactsById(Collection<CharacterAtrefact> characterAtrefactsById) {
        this.characterAtrefactsById = characterAtrefactsById;
    }

    @OneToMany(mappedBy = "playerCharacterByPlayerCharacterId")
    public Collection<PartyCharacter> getPartyCharactersById() {
        return partyCharactersById;
    }

    public void setPartyCharactersById(Collection<PartyCharacter> partyCharactersById) {
        this.partyCharactersById = partyCharactersById;
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
    @JoinColumn(name = "Character_Id", referencedColumnName = "Id", nullable = false)
    public Character getCharacterByCharacterId() {
        return characterByCharacterId;
    }

    public void setCharacterByCharacterId(Character characterByCharacterId) {
        this.characterByCharacterId = characterByCharacterId;
    }

    @OneToMany(mappedBy = "playerCharacterByWieldingCharacter")
    public Collection<PlayerWeapon> getPlayerWeaponsById() {
        return playerWeaponsById;
    }

    public void setPlayerWeaponsById(Collection<PlayerWeapon> playerWeaponsById) {
        this.playerWeaponsById = playerWeaponsById;
    }
}
