package com.gachaapi.Repository;

import com.gachaapi.Entity.StatArtefactset;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SetStatsRepository extends JpaRepository<StatArtefactset, Integer> {
}
