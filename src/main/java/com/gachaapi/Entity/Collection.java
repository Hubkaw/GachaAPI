package com.gachaapi.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Collection {
    private int idCollection;
    private String name;
    private java.util.Collection<Chest> chestsByIdCollection;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDCollection", nullable = false)
    public int getIdCollection() {
        return idCollection;
    }

    public void setIdCollection(int idCollection) {
        this.idCollection = idCollection;
    }

    @Basic
    @Column(name = "Name", nullable = false, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Collection that = (Collection) o;
        return idCollection == that.idCollection && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCollection, name);
    }

    @OneToMany(mappedBy = "collectionByCollectionIdCollection")
    public java.util.Collection<Chest> getChestsByIdCollection() {
        return chestsByIdCollection;
    }

    public void setChestsByIdCollection(java.util.Collection<Chest> chestsByIdCollection) {
        this.chestsByIdCollection = chestsByIdCollection;
    }
}
