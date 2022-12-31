package com.gachaapi.Repository;

import com.gachaapi.Entity.BattleHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BattleLogRepository extends JpaRepository<BattleHistory, Integer> {
    List<BattleHistory> findAllByAttackerNickOrDefenderNick(String attackerNick, String defenderNick);
    List<BattleHistory> findAllByAttackerNick(String nick);
    List<BattleHistory> findAllByDefenderNick(String nick);
}
