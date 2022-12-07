package com.gachaapi.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gachaapi.Utils.PossibleChestReward;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
public class Character  implements PossibleChestReward {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private int id;

    @Basic
    @Column(name = "Name", nullable = false, length = 32)
    private String name;

    @Basic
    @Column(name = "Ability", nullable = false, length = 64)
    private String ability;

    @ManyToOne
    @JoinColumn(name = "Affilation_id", referencedColumnName = "id", nullable = false)
    private Affilation affilation;

    @ManyToOne
    @JoinColumn(name = "Class_id", referencedColumnName = "id", nullable = false)
    private Clazz characterClass;

    @ManyToOne
    @JoinColumn(name = "Rarity_id", referencedColumnName = "id", nullable = false)
    private Rarity rarity;

    @ManyToMany(cascade = {
            CascadeType.ALL
    })
    @JoinTable(name = "character_chest" ,
            joinColumns = {
                    @JoinColumn(name = "Character_Id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "Chest_IdChest")
            })
    @JsonIgnore
    private Set<Chest> chests;

    @OneToMany(mappedBy = "character")
    @JsonIgnore
    private Collection<PlayerCharacter> playerCharactersById;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Character character = (Character) o;
        return id == character.id && ability == character.ability && Objects.equals(name, character.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, ability);
    }

    @Override
    public int getWeight() {
        return rarity.getWeight();
    }
}
