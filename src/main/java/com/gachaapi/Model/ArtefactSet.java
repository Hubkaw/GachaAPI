package com.gachaapi.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Artefact_Set", schema = "dbo", catalog = "gacha")
@IdClass(ArtefactSetPK.class)
public class ArtefactSet {
    private int setId;
    private int artefactId;
    private Set setBySetId;
    private Artefact artefactByArtefactId;

    @Id
    @Column(name = "Set_Id", nullable = false)
    public int getSetId() {
        return setId;
    }

    public void setSetId(int setId) {
        this.setId = setId;
    }

    @Id
    @Column(name = "Artefact_Id", nullable = false)
    public int getArtefactId() {
        return artefactId;
    }

    public void setArtefactId(int artefactId) {
        this.artefactId = artefactId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArtefactSet that = (ArtefactSet) o;
        return setId == that.setId && artefactId == that.artefactId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(setId, artefactId);
    }

    @ManyToOne
    @JoinColumn(name = "Set_Id", referencedColumnName = "Id", nullable = false)
    public Set getSetBySetId() {
        return setBySetId;
    }

    public void setSetBySetId(Set setBySetId) {
        this.setBySetId = setBySetId;
    }

    @ManyToOne
    @JoinColumn(name = "Artefact_Id", referencedColumnName = "Id", nullable = false)
    public Artefact getArtefactByArtefactId() {
        return artefactByArtefactId;
    }

    public void setArtefactByArtefactId(Artefact artefactByArtefactId) {
        this.artefactByArtefactId = artefactByArtefactId;
    }
}
