package com.gachaapi.Model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Artefact {
    private int id;
    private String name;
    private int rarityId;
    private Rarity rarityByRarityId;
    private Collection<ArtefactSet> artefactSetsById;
    private Collection<PlayerArtefact> playerArtefactsById;
    private Collection<StatArtifact> statArtifactsById;

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
    @Column(name = "Rarity_id", nullable = false)
    public int getRarityId() {
        return rarityId;
    }

    public void setRarityId(int rarityId) {
        this.rarityId = rarityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artefact artefact = (Artefact) o;
        return id == artefact.id && rarityId == artefact.rarityId && Objects.equals(name, artefact.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, rarityId);
    }

    @ManyToOne
    @JoinColumn(name = "Rarity_id", referencedColumnName = "id", nullable = false)
    public Rarity getRarityByRarityId() {
        return rarityByRarityId;
    }

    public void setRarityByRarityId(Rarity rarityByRarityId) {
        this.rarityByRarityId = rarityByRarityId;
    }

    @OneToMany(mappedBy = "artefactByArtefactId")
    public Collection<ArtefactSet> getArtefactSetsById() {
        return artefactSetsById;
    }

    public void setArtefactSetsById(Collection<ArtefactSet> artefactSetsById) {
        this.artefactSetsById = artefactSetsById;
    }

    @OneToMany(mappedBy = "artefactByArtefactId")
    public Collection<PlayerArtefact> getPlayerArtefactsById() {
        return playerArtefactsById;
    }

    public void setPlayerArtefactsById(Collection<PlayerArtefact> playerArtefactsById) {
        this.playerArtefactsById = playerArtefactsById;
    }

    @OneToMany(mappedBy = "artefactByArtefactId")
    public Collection<StatArtifact> getStatArtifactsById() {
        return statArtifactsById;
    }

    public void setStatArtifactsById(Collection<StatArtifact> statArtifactsById) {
        this.statArtifactsById = statArtifactsById;
    }
}
