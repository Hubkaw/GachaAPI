package com.gachaapi.Repository;

import com.gachaapi.Entity.Affilation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AffiliationRepository extends JpaRepository<Affilation, Integer> {
}
