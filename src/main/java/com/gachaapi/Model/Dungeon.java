package com.gachaapi.Model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Dungeon {
    private int id;
    private String name;
    private int rewardId;
    private Date releasedAt;
    private Date expiresAt;
    private Reward rewardByRewardId;
    private Collection<DungeonFloorDungeon> dungeonFloorDungeonsById;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Name", nullable = false, length = 32)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "Reward_ID", nullable = false)
    public int getRewardId() {
        return rewardId;
    }

    public void setRewardId(int rewardId) {
        this.rewardId = rewardId;
    }

    @Basic
    @Column(name = "ReleasedAt", nullable = false)
    public Date getReleasedAt() {
        return releasedAt;
    }

    public void setReleasedAt(Date releasedAt) {
        this.releasedAt = releasedAt;
    }

    @Basic
    @Column(name = "ExpiresAt", nullable = true)
    public Date getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(Date expiresAt) {
        this.expiresAt = expiresAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dungeon dungeon = (Dungeon) o;
        return id == dungeon.id && rewardId == dungeon.rewardId && Objects.equals(name, dungeon.name) && Objects.equals(releasedAt, dungeon.releasedAt) && Objects.equals(expiresAt, dungeon.expiresAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, rewardId, releasedAt, expiresAt);
    }

    @ManyToOne
    @JoinColumn(name = "Reward_ID", referencedColumnName = "ID", nullable = false)
    public Reward getRewardByRewardId() {
        return rewardByRewardId;
    }

    public void setRewardByRewardId(Reward rewardByRewardId) {
        this.rewardByRewardId = rewardByRewardId;
    }

    @OneToMany(mappedBy = "dungeonByDungeonId")
    public Collection<DungeonFloorDungeon> getDungeonFloorDungeonsById() {
        return dungeonFloorDungeonsById;
    }

    public void setDungeonFloorDungeonsById(Collection<DungeonFloorDungeon> dungeonFloorDungeonsById) {
        this.dungeonFloorDungeonsById = dungeonFloorDungeonsById;
    }
}
