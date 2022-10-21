package com.gachaapi.Model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Player {
    private int idPlayer;
    private String nick;
    private Date birthDate;
    private Date joinDate;
    private int activeParty;
    private int playerBalance;
    private String hashedPassword;
    private float pityRollStatus;
    private int pvpWins;
    private int pvpLooses;
    private int eloPoints;
    private Collection<Party> partiesByIdPlayer;
    private Collection<PlayerArtefact> playerArtefactsByIdPlayer;
    private Collection<PlayerCharacter> playerCharactersByIdPlayer;
    private Collection<PlayerChestItem> playerChestItemsByIdPlayer;
    private Collection<PlayerDungeonFloor> playerDungeonFloorsByIdPlayer;
    private Collection<PlayerMaterial> playerMaterialsByIdPlayer;
    private Collection<PlayerPurchase> playerPurchasesByIdPlayer;
    private Collection<PlayerWeapon> playerWeaponsByIdPlayer;

    @Id
    @Column(name = "IdPlayer", nullable = false)
    public int getIdPlayer() {
        return idPlayer;
    }

    public void setIdPlayer(int idPlayer) {
        this.idPlayer = idPlayer;
    }

    @Basic
    @Column(name = "Nick", nullable = false, length = 32)
    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    @Basic
    @Column(name = "BirthDate", nullable = false)
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Basic
    @Column(name = "JoinDate", nullable = false)
    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    @Basic
    @Column(name = "ActiveParty", nullable = false)
    public int getActiveParty() {
        return activeParty;
    }

    public void setActiveParty(int activeParty) {
        this.activeParty = activeParty;
    }

    @Basic
    @Column(name = "PlayerBalance", nullable = false)
    public int getPlayerBalance() {
        return playerBalance;
    }

    public void setPlayerBalance(int playerBalance) {
        this.playerBalance = playerBalance;
    }

    @Basic
    @Column(name = "HashedPassword", nullable = false, length = 126)
    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    @Basic
    @Column(name = "PityRollStatus", nullable = false, precision = 0)
    public float getPityRollStatus() {
        return pityRollStatus;
    }

    public void setPityRollStatus(float pityRollStatus) {
        this.pityRollStatus = pityRollStatus;
    }

    @Basic
    @Column(name = "PVPWins", nullable = false)
    public int getPvpWins() {
        return pvpWins;
    }

    public void setPvpWins(int pvpWins) {
        this.pvpWins = pvpWins;
    }

    @Basic
    @Column(name = "PVPLooses", nullable = false)
    public int getPvpLooses() {
        return pvpLooses;
    }

    public void setPvpLooses(int pvpLooses) {
        this.pvpLooses = pvpLooses;
    }

    @Basic
    @Column(name = "ELOPoints", nullable = false)
    public int getEloPoints() {
        return eloPoints;
    }

    public void setEloPoints(int eloPoints) {
        this.eloPoints = eloPoints;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return idPlayer == player.idPlayer && activeParty == player.activeParty && playerBalance == player.playerBalance && Float.compare(player.pityRollStatus, pityRollStatus) == 0 && pvpWins == player.pvpWins && pvpLooses == player.pvpLooses && eloPoints == player.eloPoints && Objects.equals(nick, player.nick) && Objects.equals(birthDate, player.birthDate) && Objects.equals(joinDate, player.joinDate) && Objects.equals(hashedPassword, player.hashedPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPlayer, nick, birthDate, joinDate, activeParty, playerBalance, hashedPassword, pityRollStatus, pvpWins, pvpLooses, eloPoints);
    }

    @OneToMany(mappedBy = "playerByPlayerIdPlayer")
    public Collection<Party> getPartiesByIdPlayer() {
        return partiesByIdPlayer;
    }

    public void setPartiesByIdPlayer(Collection<Party> partiesByIdPlayer) {
        this.partiesByIdPlayer = partiesByIdPlayer;
    }

    @OneToMany(mappedBy = "playerByPlayerIdPlayer")
    public Collection<PlayerArtefact> getPlayerArtefactsByIdPlayer() {
        return playerArtefactsByIdPlayer;
    }

    public void setPlayerArtefactsByIdPlayer(Collection<PlayerArtefact> playerArtefactsByIdPlayer) {
        this.playerArtefactsByIdPlayer = playerArtefactsByIdPlayer;
    }

    @OneToMany(mappedBy = "playerByPlayerIdPlayer")
    public Collection<PlayerCharacter> getPlayerCharactersByIdPlayer() {
        return playerCharactersByIdPlayer;
    }

    public void setPlayerCharactersByIdPlayer(Collection<PlayerCharacter> playerCharactersByIdPlayer) {
        this.playerCharactersByIdPlayer = playerCharactersByIdPlayer;
    }

    @OneToMany(mappedBy = "playerByPlayerIdPlayer")
    public Collection<PlayerChestItem> getPlayerChestItemsByIdPlayer() {
        return playerChestItemsByIdPlayer;
    }

    public void setPlayerChestItemsByIdPlayer(Collection<PlayerChestItem> playerChestItemsByIdPlayer) {
        this.playerChestItemsByIdPlayer = playerChestItemsByIdPlayer;
    }

    @OneToMany(mappedBy = "playerByPlayerIdPlayer")
    public Collection<PlayerDungeonFloor> getPlayerDungeonFloorsByIdPlayer() {
        return playerDungeonFloorsByIdPlayer;
    }

    public void setPlayerDungeonFloorsByIdPlayer(Collection<PlayerDungeonFloor> playerDungeonFloorsByIdPlayer) {
        this.playerDungeonFloorsByIdPlayer = playerDungeonFloorsByIdPlayer;
    }

    @OneToMany(mappedBy = "playerByPlayerIdPlayer")
    public Collection<PlayerMaterial> getPlayerMaterialsByIdPlayer() {
        return playerMaterialsByIdPlayer;
    }

    public void setPlayerMaterialsByIdPlayer(Collection<PlayerMaterial> playerMaterialsByIdPlayer) {
        this.playerMaterialsByIdPlayer = playerMaterialsByIdPlayer;
    }

    @OneToMany(mappedBy = "playerByPlayerIdPlayer")
    public Collection<PlayerPurchase> getPlayerPurchasesByIdPlayer() {
        return playerPurchasesByIdPlayer;
    }

    public void setPlayerPurchasesByIdPlayer(Collection<PlayerPurchase> playerPurchasesByIdPlayer) {
        this.playerPurchasesByIdPlayer = playerPurchasesByIdPlayer;
    }

    @OneToMany(mappedBy = "playerByPlayerIdPlayer")
    public Collection<PlayerWeapon> getPlayerWeaponsByIdPlayer() {
        return playerWeaponsByIdPlayer;
    }

    public void setPlayerWeaponsByIdPlayer(Collection<PlayerWeapon> playerWeaponsByIdPlayer) {
        this.playerWeaponsByIdPlayer = playerWeaponsByIdPlayer;
    }
}
