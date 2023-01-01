package com.gachaapi.Service.interfaces;

import com.gachaapi.Entity.BattleHistory;

import java.util.List;

public interface BattleLogsService {
    List<BattleHistory> getAll();
    List<BattleHistory> getAllByPlayer(String nickname);
    List<BattleHistory> getAllByAttacker(String nickname);
    List<BattleHistory> getAllByDefender(String nickname);
}
