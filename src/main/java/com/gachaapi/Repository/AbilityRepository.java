package com.gachaapi.Repository;

import com.gachaapi.Entity.Ability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbilityRepository extends JpaRepository<Ability, Integer> {
}
