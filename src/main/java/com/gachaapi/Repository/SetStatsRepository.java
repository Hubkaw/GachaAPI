package com.gachaapi.Repository;

import com.gachaapi.Entity.StatArtefactset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SetStatsRepository extends JpaRepository<StatArtefactset, Integer> {
}
