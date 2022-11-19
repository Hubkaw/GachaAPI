package com.gachaapi.Entity;

import lombok.Data;
import org.springframework.security.core.parameters.P;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Data
@Entity
public class Weapon {

    @Id
    @Column(name = "Id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Basic
    @Column(name = "Name", nullable = false, length = 64)
    private String name;

    @OneToMany(mappedBy = "weaponByWeaponId")
    private Collection<PlayerWeapon> playerWeaponsById;

    @OneToMany(mappedBy = "weaponByWeaponId")
    private Collection<StatWeapon> statWeaponsById;

    @ManyToOne
    @JoinColumn(name = "Element_id", referencedColumnName = "id", nullable = false)
    private Element elementByElementId;

    @ManyToOne
    @JoinColumn(name = "Rarity_id", referencedColumnName = "id", nullable = false)
    private Rarity rarityByRarityId;

    @ManyToOne
    @JoinColumn(name = "WeaponClass_Id", referencedColumnName = "Id", nullable = false)
    private Weaponclass weaponclassByWeaponClassId;

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
    private Collection<Chest> chests;

    @OneToMany(mappedBy = "weaponByWeaponId")
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
}
