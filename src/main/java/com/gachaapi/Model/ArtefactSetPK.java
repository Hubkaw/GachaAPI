package com.gachaapi.Model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ArtefactSetPK implements Serializable {
    private int setId;
    private int artefactId;

    @Column(name = "Set_Id", nullable = false)
    @Id
    public int getSetId() {
        return setId;
    }

    public void setSetId(int setId) {
        this.setId = setId;
    }

    @Column(name = "Artefact_Id", nullable = false)
    @Id
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
        ArtefactSetPK that = (ArtefactSetPK) o;
        return setId == that.setId && artefactId == that.artefactId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(setId, artefactId);
    }
}
