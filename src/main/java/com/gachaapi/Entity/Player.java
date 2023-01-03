package com.gachaapi.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
public class Player {

    @Id
    @Column(name = "IdPlayer", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPlayer;

    @Basic
    @Column(name = "Nick", nullable = false, length = 32, unique = true)
    private String nick;

    @Basic
    @Column(name = "BirthDate", nullable = false)
    private Timestamp birthDate;

    @Basic
    @Column(name = "JoinDate", nullable = false)
    private Timestamp joinDate;

    @Basic
    @Column(name = "ActiveParty", nullable = false)
    private int activeParty;

    @Basic
    @Column(name = "PlayerBalance", nullable = false)
    private int playerBalance;

    @Basic
    @Column(name = "HashedPassword", nullable = false, length = 126)
    @JsonIgnore
    private String hashedPassword;

    @Basic
    @Column(name = "PityRollStatus", nullable = false)
    private int pityRollStatus;

    @Basic
    @Column(name = "ELOPoints", nullable = false)
    private int eloPoints;

    @Basic
    @Column(name = "PremiumLeft", nullable = false)
    private int premiumLeft;

    @Basic
    @Column(name = "Stamina", nullable = false)
    private int stamina;

    @OneToMany(mappedBy = "player")

    private Collection<Party> parties;


    @OneToMany(mappedBy = "player")
    private Collection<PlayerArtefact> playerArtefacts;


    @OneToMany(mappedBy = "player")
    private Collection<PlayerCharacter> playerCharacters;


    @OneToMany(mappedBy = "playerByPlayerIdPlayer")
    private Collection<PlayerChestitem> playerChestitems;


    @OneToMany(mappedBy = "player")
    private Collection<PlayerDungeonfloor> playerDungeonfloors;


    @OneToMany(mappedBy = "player")
    private Collection<PlayerMaterial> playerMaterials;


    @OneToMany(mappedBy = "playerByPlayerIdPlayer")
    private Collection<PlayerPurchase> playerPurchases;


    @OneToMany(mappedBy = "player")
    private Set<PlayerWeapon> playerWeapons;


    @OneToMany(mappedBy = "attacker")
    private List<BattleHistory> attacks;

    @OneToMany(mappedBy = "defender")
    private List<BattleHistory> defences;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "Player_Role",
            joinColumns = {
                    @JoinColumn(name = "Player_Player_Id")

            },
            inverseJoinColumns = {
                    @JoinColumn(name = "Role_Id")
            })

    private Set<Role> roles;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return idPlayer == player.idPlayer && activeParty == player.activeParty && playerBalance == player.playerBalance && pityRollStatus == player.pityRollStatus && eloPoints == player.eloPoints && Objects.equals(nick, player.nick) && Objects.equals(birthDate, player.birthDate) && Objects.equals(joinDate, player.joinDate) && Objects.equals(hashedPassword, player.hashedPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPlayer, nick, birthDate, joinDate, activeParty, playerBalance, hashedPassword, pityRollStatus, eloPoints);
    }

    public void incrementPity(){
        pityRollStatus++;
    }

    @Override
    public String toString(){
        return nick;
    }

    public boolean pay(int amount){
        if (getPlayerBalance()<amount)
            return false;
        setPlayerBalance(getPlayerBalance()-amount);
        return true;
    }
}
