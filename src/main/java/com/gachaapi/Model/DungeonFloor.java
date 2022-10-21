package com.gachaapi.Model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class DungeonFloor {
    private int id;
    private int rewardId;
    private Reward rewardByRewardId;
    private Collection<DungeonFloorDungeon> dungeonFloorDungeonsById;
    private Collection<PartyDungeonFloor> partyDungeonFloorsById;
    private Collection<PlayerDungeonFloor> playerDungeonFloorsById;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Reward_ID", nullable = false)
    public int getRewardId() {
        return rewardId;
    }

    public void setRewardId(int rewardId) {
        this.rewardId = rewardId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DungeonFloor that = (DungeonFloor) o;
        return id == that.id && rewardId == that.rewardId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rewardId);
    }

    @ManyToOne
    @JoinColumn(name = "Reward_ID", referencedColumnName = "ID", nullable = false)
    public Reward getRewardByRewardId() {
        return rewardByRewardId;
    }

    public void setRewardByRewardId(Reward rewardByRewardId) {
        this.rewardByRewardId = rewardByRewardId;
    }

    @OneToMany(mappedBy = "dungeonFloorByDungeonFloorId")
    public Collection<DungeonFloorDungeon> getDungeonFloorDungeonsById() {
        return dungeonFloorDungeonsById;
    }

    public void setDungeonFloorDungeonsById(Collection<DungeonFloorDungeon> dungeonFloorDungeonsById) {
        this.dungeonFloorDungeonsById = dungeonFloorDungeonsById;
    }

    @OneToMany(mappedBy = "dungeonFloorByDungeonFloorId")
    public Collection<PartyDungeonFloor> getPartyDungeonFloorsById() {
        return partyDungeonFloorsById;
    }

    public void setPartyDungeonFloorsById(Collection<PartyDungeonFloor> partyDungeonFloorsById) {
        this.partyDungeonFloorsById = partyDungeonFloorsById;
    }

    @OneToMany(mappedBy = "dungeonFloorByDungeonFloorId")
    public Collection<PlayerDungeonFloor> getPlayerDungeonFloorsById() {
        return playerDungeonFloorsById;
    }

    public void setPlayerDungeonFloorsById(Collection<PlayerDungeonFloor> playerDungeonFloorsById) {
        this.playerDungeonFloorsById = playerDungeonFloorsById;
    }
}
