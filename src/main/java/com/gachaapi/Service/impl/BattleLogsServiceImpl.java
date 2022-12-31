package com.gachaapi.Service.impl;

import com.gachaapi.Entity.BattleHistory;
import com.gachaapi.Repository.BattleLogRepository;
import com.gachaapi.Service.interfaces.BattleLogsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BattleLogsServiceImpl implements BattleLogsService {

    private BattleLogRepository battleLogRepository;

    @Override
    public List<BattleHistory> getAll() {
        return battleLogRepository.findAll();
    }

    @Override
    public List<BattleHistory> getAllByPlayer(String nickname) {
        return battleLogRepository.findAllByAttackerNickOrDefenderNick(nickname, nickname);
    }

    @Override
    public List<BattleHistory> getAllByAttacker(String nickname) {
        return battleLogRepository.findAllByAttackerNick(nickname);
    }

    @Override
    public List<BattleHistory> getAllByDefender(String nickname) {
        return battleLogRepository.findAllByDefenderNick(nickname);
    }
}
