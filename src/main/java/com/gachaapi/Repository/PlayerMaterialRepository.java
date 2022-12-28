package com.gachaapi.Repository;

import com.gachaapi.Entity.PlayerMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerMaterialRepository extends JpaRepository<PlayerMaterial, Integer> {
    List<PlayerMaterial> findAllByPlayerNick(String nickname);
}
