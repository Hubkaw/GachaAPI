package com.gachaapi.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Player_Weapon", schema = "dbo", catalog = "gacha")
public class PlayerWeapon {
    private int id;
    private int wieldingCharacter;
    private int playerIdPlayer;
    private int weaponId;
    private int ascension;
    private int lvl;
    private PlayerCharacter playerCharacterByWieldingCharacter;
    private Player playerByPlayerIdPlayer;
    private Weapon weaponByWeaponId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "WieldingCharacter", nullable = false)
    public int getWieldingCharacter() {
        return wieldingCharacter;
    }

    public void setWieldingCharacter(int wieldingCharacter) {
        this.wieldingCharacter = wieldingCharacter;
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
    @Column(name = "Weapon_Id", nullable = false)
    public int getWeaponId() {
        return weaponId;
    }

    public void setWeaponId(int weaponId) {
        this.weaponId = weaponId;
    }

    @Basic
    @Column(name = "Ascension", nullable = false)
    public int getAscension() {
        return ascension;
    }

    public void setAscension(int ascension) {
        this.ascension = ascension;
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
        PlayerWeapon that = (PlayerWeapon) o;
        return id == that.id && wieldingCharacter == that.wieldingCharacter && playerIdPlayer == that.playerIdPlayer && weaponId == that.weaponId && ascension == that.ascension && lvl == that.lvl;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, wieldingCharacter, playerIdPlayer, weaponId, ascension, lvl);
    }

    @ManyToOne
    @JoinColumn(name = "WieldingCharacter", referencedColumnName = "Id", nullable = false)
    public PlayerCharacter getPlayerCharacterByWieldingCharacter() {
        return playerCharacterByWieldingCharacter;
    }

    public void setPlayerCharacterByWieldingCharacter(PlayerCharacter playerCharacterByWieldingCharacter) {
        this.playerCharacterByWieldingCharacter = playerCharacterByWieldingCharacter;
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
    @JoinColumn(name = "Weapon_Id", referencedColumnName = "Id", nullable = false)
    public Weapon getWeaponByWeaponId() {
        return weaponByWeaponId;
    }

    public void setWeaponByWeaponId(Weapon weaponByWeaponId) {
        this.weaponByWeaponId = weaponByWeaponId;
    }
}
