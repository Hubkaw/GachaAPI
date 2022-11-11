package com.gachaapi.Entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Dungeon {
    private int id;
    private String name;
    private Timestamp releasedAt;
    private Timestamp expiresAt;
    private Collection<Dungeonfloor> dungeonfloorsById;

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
    @Column(name = "ReleasedAt", nullable = false)
    public Timestamp getReleasedAt() {
        return releasedAt;
    }

    public void setReleasedAt(Timestamp releasedAt) {
        this.releasedAt = releasedAt;
    }

    @Basic
    @Column(name = "ExpiresAt", nullable = true)
    public Timestamp getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(Timestamp expiresAt) {
        this.expiresAt = expiresAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dungeon dungeon = (Dungeon) o;
        return id == dungeon.id && Objects.equals(name, dungeon.name) && Objects.equals(releasedAt, dungeon.releasedAt) && Objects.equals(expiresAt, dungeon.expiresAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, releasedAt, expiresAt);
    }

    @OneToMany(mappedBy = "dungeonByDungeonId")
    public Collection<Dungeonfloor> getDungeonfloorsById() {
        return dungeonfloorsById;
    }

    public void setDungeonfloorsById(Collection<Dungeonfloor> dungeonfloorsById) {
        this.dungeonfloorsById = dungeonfloorsById;
    }
}
