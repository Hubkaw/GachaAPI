package com.gachaapi.Repository;

import com.gachaapi.Entity.PlayerCharacter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerCharacterRepository extends JpaRepository<PlayerCharacter, Integer> {
}
