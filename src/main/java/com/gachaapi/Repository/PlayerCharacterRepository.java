package com.gachaapi.Repository;

import com.gachaapi.Entity.PlayerCharacter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerCharacterRepository extends JpaRepository<PlayerCharacter, Integer> {
    List<PlayerCharacter> findAllByPlayer_IdPlayer(int id);
}
