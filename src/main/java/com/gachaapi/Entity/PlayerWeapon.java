package com.gachaapi.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "player_weapon", schema = "gacha", catalog = "")
public class PlayerWeapon {
    private int id;
    private int lvl;
    @JsonIgnore
    private PlayerCharacter wieldingCharacter;
    @JsonIgnore
    private Player player;
    private Weapon weapon;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return id == that.id && lvl == that.lvl;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lvl);
    }

    @OneToOne(mappedBy = "wieldedWeapon")
    public PlayerCharacter getWieldingCharacter() {
        return wieldingCharacter;
    }

    public void setWieldingCharacter(PlayerCharacter playerCharacterByWieldingCharacter) {
        this.wieldingCharacter = playerCharacterByWieldingCharacter;
    }

    @ManyToOne
    @JoinColumn(name = "Player_IdPlayer", referencedColumnName = "IdPlayer", nullable = false)
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player playerByPlayerIdPlayer) {
        this.player = playerByPlayerIdPlayer;
    }

    @ManyToOne
    @JoinColumn(name = "Weapon_Id", referencedColumnName = "Id", nullable = false)
    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weaponByWeaponId) {
        this.weapon = weaponByWeaponId;
    }
}
