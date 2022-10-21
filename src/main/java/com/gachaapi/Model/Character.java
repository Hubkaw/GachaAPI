package com.gachaapi.Model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Character {
    private int id;
    private String name;
    private int affilationId;
    private int ability;
    private int classId;
    private Affilation affilationByAffilationId;
    private Clazz clazzByClassId;
    private Collection<CharacterChest> characterChestsById;
    private Collection<PlayerCharacter> playerCharactersById;

    @Id
    @Column(name = "Id", nullable = false)
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
    @Column(name = "Affilation_id", nullable = false)
    public int getAffilationId() {
        return affilationId;
    }

    public void setAffilationId(int affilationId) {
        this.affilationId = affilationId;
    }

    @Basic
    @Column(name = "Ability", nullable = false)
    public int getAbility() {
        return ability;
    }

    public void setAbility(int ability) {
        this.ability = ability;
    }

    @Basic
    @Column(name = "Class_id", nullable = false)
    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Character character = (Character) o;
        return id == character.id && affilationId == character.affilationId && ability == character.ability && classId == character.classId && Objects.equals(name, character.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, affilationId, ability, classId);
    }

    @ManyToOne
    @JoinColumn(name = "Affilation_id", referencedColumnName = "id", nullable = false)
    public Affilation getAffilationByAffilationId() {
        return affilationByAffilationId;
    }

    public void setAffilationByAffilationId(Affilation affilationByAffilationId) {
        this.affilationByAffilationId = affilationByAffilationId;
    }

    @ManyToOne
    @JoinColumn(name = "Class_id", referencedColumnName = "id", nullable = false)
    public Clazz getClazzByClassId() {
        return clazzByClassId;
    }

    public void setClazzByClassId(Clazz clazzByClassId) {
        this.clazzByClassId = clazzByClassId;
    }

    @OneToMany(mappedBy = "characterByCharacterId")
    public Collection<CharacterChest> getCharacterChestsById() {
        return characterChestsById;
    }

    public void setCharacterChestsById(Collection<CharacterChest> characterChestsById) {
        this.characterChestsById = characterChestsById;
    }

    @OneToMany(mappedBy = "characterByCharacterId")
    public Collection<PlayerCharacter> getPlayerCharactersById() {
        return playerCharactersById;
    }

    public void setPlayerCharactersById(Collection<PlayerCharacter> playerCharactersById) {
        this.playerCharactersById = playerCharactersById;
    }
}
