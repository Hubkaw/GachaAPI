package com.gachaapi.Repository;

import com.gachaapi.Entity.Materialaffilation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialAffiliationRepository extends JpaRepository<Materialaffilation, Integer> {
}
