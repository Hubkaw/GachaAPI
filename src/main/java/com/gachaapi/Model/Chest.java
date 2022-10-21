package com.gachaapi.Model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Chest {
    private int idChest;
    private String name;
    private int collectionIdCollection;
    private Date releasedAt;
    private Date expiresAt;
    private Collection<CharacterChest> characterChestsByIdChest;
    private com.gachaapi.Model.Collection collectionByCollectionIdCollection;
    private Collection<ChestReward> chestRewardsByIdChest;
    private Collection<PlayerChestItem> playerChestItemsByIdChest;
    private Collection<WeaponChest> weaponChestsByIdChest;

    @Id
    @Column(name = "IdChest", nullable = false)
    public int getIdChest() {
        return idChest;
    }

    public void setIdChest(int idChest) {
        this.idChest = idChest;
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
    @Column(name = "Collection_IDCollection", nullable = false)
    public int getCollectionIdCollection() {
        return collectionIdCollection;
    }

    public void setCollectionIdCollection(int collectionIdCollection) {
        this.collectionIdCollection = collectionIdCollection;
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
        Chest chest = (Chest) o;
        return idChest == chest.idChest && collectionIdCollection == chest.collectionIdCollection && Objects.equals(name, chest.name) && Objects.equals(releasedAt, chest.releasedAt) && Objects.equals(expiresAt, chest.expiresAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idChest, name, collectionIdCollection, releasedAt, expiresAt);
    }

    @OneToMany(mappedBy = "chestByChestIdChest")
    public Collection<CharacterChest> getCharacterChestsByIdChest() {
        return characterChestsByIdChest;
    }

    public void setCharacterChestsByIdChest(Collection<CharacterChest> characterChestsByIdChest) {
        this.characterChestsByIdChest = characterChestsByIdChest;
    }

    @ManyToOne
    @JoinColumn(name = "Collection_IDCollection", referencedColumnName = "IDCollection", nullable = false)
    public com.gachaapi.Model.Collection getCollectionByCollectionIdCollection() {
        return collectionByCollectionIdCollection;
    }

    public void setCollectionByCollectionIdCollection(com.gachaapi.Model.Collection collectionByCollectionIdCollection) {
        this.collectionByCollectionIdCollection = collectionByCollectionIdCollection;
    }

    @OneToMany(mappedBy = "chestByChestIdChest")
    public Collection<ChestReward> getChestRewardsByIdChest() {
        return chestRewardsByIdChest;
    }

    public void setChestRewardsByIdChest(Collection<ChestReward> chestRewardsByIdChest) {
        this.chestRewardsByIdChest = chestRewardsByIdChest;
    }

    @OneToMany(mappedBy = "chestByChestIdChest")
    public Collection<PlayerChestItem> getPlayerChestItemsByIdChest() {
        return playerChestItemsByIdChest;
    }

    public void setPlayerChestItemsByIdChest(Collection<PlayerChestItem> playerChestItemsByIdChest) {
        this.playerChestItemsByIdChest = playerChestItemsByIdChest;
    }

    @OneToMany(mappedBy = "chestByChestIdChest")
    public Collection<WeaponChest> getWeaponChestsByIdChest() {
        return weaponChestsByIdChest;
    }

    public void setWeaponChestsByIdChest(Collection<WeaponChest> weaponChestsByIdChest) {
        this.weaponChestsByIdChest = weaponChestsByIdChest;
    }
}
