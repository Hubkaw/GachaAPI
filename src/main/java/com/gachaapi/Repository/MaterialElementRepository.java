package com.gachaapi.Repository;

import com.gachaapi.Entity.Materialelement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialElementRepository extends JpaRepository<Materialelement, Integer> {
}
