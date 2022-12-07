package com.gachaapi.Repository;

import com.gachaapi.Entity.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SetRepository extends JpaRepository<Set, Integer> {
}
