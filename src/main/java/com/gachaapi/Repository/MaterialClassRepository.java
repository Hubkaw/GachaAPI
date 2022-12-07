package com.gachaapi.Repository;

import com.gachaapi.Entity.Materialclass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialClassRepository extends JpaRepository<Materialclass, Integer> {
}
