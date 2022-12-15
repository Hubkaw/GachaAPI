package com.gachaapi.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gachaapi.Utils.ArtefactType;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Data
@Entity
public class Artefact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private int id;

    @Basic
    @Column(name = "Name", nullable = false, length = 32)
    private String name;


    @Basic
    @Column(name = "Type", nullable = false, length = 12)
    private ArtefactType type;


    @ManyToOne
    @JoinColumn(name = "Rarity_id", referencedColumnName = "id", nullable = false)
    private Rarity rarity;

    @OneToMany(mappedBy = "artefact")
    @JsonIgnore
    private Collection<ArtefactReward> artefactRewards;

    @ManyToMany(cascade = {
            CascadeType.PERSIST
    })
    @JoinTable(name = "artefact_set" ,
            joinColumns = {
                    @JoinColumn(name = "Artefact_Id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "Set_Id")
            })
    private java.util.Set<com.gachaapi.Entity.Set> sets;

    @OneToMany(mappedBy = "artefactByArtefactId")
    @JsonIgnore
    private Collection<PlayerArtefact> playerArtefacts;

    @OneToMany(mappedBy = "artefactByArtefactId", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private Collection<StatArtifact> statArtifacts;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artefact artefact = (Artefact) o;
        return id == artefact.id && Objects.equals(name, artefact.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

}
