package com.gachaapi.Repository;

import com.gachaapi.Entity.Artefact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtefactRepository extends JpaRepository<Artefact, Integer> {
}
