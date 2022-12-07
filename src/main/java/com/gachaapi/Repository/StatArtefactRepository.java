package com.gachaapi.Repository;

import com.gachaapi.Entity.StatArtifact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatArtefactRepository extends JpaRepository<StatArtifact, Integer> {
}
