package com.gachaapi.Repository;

import com.gachaapi.Entity.Chest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChestRepository extends JpaRepository<Chest, Integer> {
}
