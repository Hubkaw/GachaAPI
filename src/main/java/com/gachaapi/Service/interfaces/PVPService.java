package com.gachaapi.Service.interfaces;

import com.gachaapi.Battle.BattleLogEntry;
import com.gachaapi.Entity.Player;

import java.util.List;

public interface PVPService {
    List<Player> getEligibleOpponents(String name);
    List<BattleLogEntry> duel(String attacker, int defender);
}
