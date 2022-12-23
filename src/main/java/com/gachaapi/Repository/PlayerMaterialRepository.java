package com.gachaapi.Repository;

import com.gachaapi.Entity.PlayerMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerMaterialRepository extends JpaRepository<PlayerMaterial, Integer> {
}
