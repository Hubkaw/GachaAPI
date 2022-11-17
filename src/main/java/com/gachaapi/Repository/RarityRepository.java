package com.gachaapi.Repository;

import com.gachaapi.Entity.Rarity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RarityRepository extends JpaRepository<Rarity, Integer> {
}
