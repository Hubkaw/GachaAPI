package com.gachaapi.Repository;


import com.gachaapi.Entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
    Optional<Player> findByNick(String nick);
    boolean existsByNick(String nick);

    List<Player> findAllByEloPointsGreaterThanEqualAndActivePartyIsNot(int eloPoints, int activeParty);



}
