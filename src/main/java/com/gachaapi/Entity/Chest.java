package com.gachaapi.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
public class Chest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IdChest", nullable = false)
    private int idChest;

    @Basic
    @Column(name = "Name", nullable = false, length = 32)
    private String name;

    @Basic
    @Column(name = "ReleasedAt", nullable = false)
    private Timestamp releasedAt;

    @Basic
    @Column(name = "ExpiresAt", nullable = true)
    private Timestamp expiresAt;

    @Basic
    @Column(name = "Price", nullable = false)
    private int price;

    @ManyToMany(cascade = {
            CascadeType.ALL
    }, fetch = FetchType.EAGER)
    @JoinTable(name = "character_chest" ,
            joinColumns = {
                    @JoinColumn(name = "Chest_IdChest")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "Character_Id")
            })
    private Set<Character> characters;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Collection_IDCollection", referencedColumnName = "IDCollection", nullable = false)
    private com.gachaapi.Entity.Collection collection;


    @OneToMany(mappedBy = "chestByChestIdChest")
    @JsonIgnore
    private Collection<PlayerChestitem> playerChestitemsByIdChest;


    @ManyToMany(cascade = {
            CascadeType.ALL
    })
    @JoinTable(name = "Weapon_Chest",
            joinColumns = {
                    @JoinColumn(name = "Chest_IdChest")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "Weapon_Id")
            })
    private Set<Weapon> weapons;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chest chest = (Chest) o;
        return idChest == chest.idChest && Objects.equals(name, chest.name) && Objects.equals(releasedAt, chest.releasedAt) && Objects.equals(expiresAt, chest.expiresAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idChest, name, releasedAt, expiresAt);
    }
}
