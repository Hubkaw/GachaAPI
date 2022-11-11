package com.gachaapi.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Data
@Entity
public class Set {

    @Id
    @Column(name = "Id", nullable = false)
    private int id;

    @Basic
    @Column(name = "Name", nullable = false, length = 32)
    private String name;

    @ManyToMany(cascade = {
            CascadeType.ALL
    })
    @JoinTable(name = "artefact_set" ,
            joinColumns = {
                    @JoinColumn(name = "Set_Id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "Artefact_Id")
            })
    private java.util.Set<Artefact> artefacts;

    @OneToMany(mappedBy = "setBySetId")
    private Collection<StatArtefactset> statArtefactsetsById;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Set set = (Set) o;
        return id == set.id && Objects.equals(name, set.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
