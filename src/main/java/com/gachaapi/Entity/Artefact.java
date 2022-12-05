package com.gachaapi.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Data
@Entity
public class Artefact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", nullable = false)
    private int id;

    @Basic
    @Column(name = "Name", nullable = false, length = 32)
    private String name;


    @Basic
    @Column(name = "Type", nullable = false, length = 12)
    private String type;


    @ManyToOne
    @JoinColumn(name = "Rarity_id", referencedColumnName = "id", nullable = false)
    private Rarity rarity;

    @OneToMany(mappedBy = "artefactByArtefactId")
    @JsonIgnore
    private Collection<ArtefactReward> artefactRewardsById;

    @ManyToMany(cascade = {
            CascadeType.ALL
    })
    @JoinTable(name = "artefact_set" ,
            joinColumns = {
                    @JoinColumn(name = "Artefact_Id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "Set_Id")
            })
    private java.util.Set<Set> sets;

    @OneToMany(mappedBy = "artefactByArtefactId")
    @JsonIgnore
    private Collection<PlayerArtefact> playerArtefactsById;

    @OneToMany(mappedBy = "artefactByArtefactId")
    private Collection<StatArtifact> statArtifactsById;


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
