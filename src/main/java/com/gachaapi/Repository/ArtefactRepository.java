package com.gachaapi.Repository;

import com.gachaapi.Entity.Artefact;
import com.gachaapi.Utils.ArtefactType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtefactRepository extends JpaRepository<Artefact, Integer> {
    List<Artefact> findAllByType(ArtefactType artefactType);
}
