package com.gachaapi.Repository;

import com.gachaapi.Entity.StatAffiliation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatAffiliationRepository extends JpaRepository<StatAffiliation, Integer> {
}
