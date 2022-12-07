package com.gachaapi.Repository;

import com.gachaapi.Entity.Artefact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtefactRepository extends JpaRepository<Artefact, Integer> {
}
