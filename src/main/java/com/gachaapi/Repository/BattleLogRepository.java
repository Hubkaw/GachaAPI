package com.gachaapi.Repository;

import com.gachaapi.Entity.BattleHistory;
import com.gachaapi.Service.interfaces.BattleLogsService;
import com.gachaapi.Utils.BattleType;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BattleLogRepository extends JpaRepository<BattleHistory, Integer> {
    List<BattleHistory> findAllByAttackerNickOrDefenderNick(String attackerNick, String defenderNick);
    List<BattleHistory> findAllByAttackerNick(String nick);
    List<BattleHistory> findAllByDefenderNick(String nick);

    BattleHistory getById(int id);
}
