package com.gachaapi.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gachaapi.Utils.PossibleChestReward;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Data
@Entity
public class Weapon implements PossibleChestReward {

    @Id
    @Column(name = "Id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @Column(name = "Name", nullable = false, length = 64)
    private String name;

    @OneToMany(mappedBy = "weapon")
    @JsonIgnore
    private Collection<PlayerWeapon> playerWeaponsById;

    @OneToMany(mappedBy = "weaponByWeaponId")
    private Collection<StatWeapon> stats;

    @ManyToOne
    @JoinColumn(name = "Element_id", referencedColumnName = "id", nullable = false)
    private Element element;

    @ManyToOne
    @JoinColumn(name = "Rarity_id", referencedColumnName = "id", nullable = false)
    private Rarity rarity;

    @ManyToOne
    @JoinColumn(name = "WeaponClass_Id", referencedColumnName = "Id", nullable = false)
    private Weaponclass weaponClass;

    @ManyToMany(cascade = {
            CascadeType.ALL
    })
    @JoinTable(name = "Weapon_Chest",
            joinColumns = {
                    @JoinColumn(name = "Weapon_Id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "Chest_IdChest")
            })
    @JsonIgnore
    private Collection<Chest> chests;

    @OneToMany(mappedBy = "weaponByWeaponId")
    @JsonIgnore
    private Collection<WeaponReward> weaponRewardsById;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weapon weapon = (Weapon) o;
        return id == weapon.id && Objects.equals(name, weapon.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public int getWeight() {
        return rarity.getWeight();
    }
}
