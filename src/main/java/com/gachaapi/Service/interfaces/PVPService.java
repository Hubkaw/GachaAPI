package com.gachaapi.Service.interfaces;

import com.gachaapi.Battle.BattleCharacter;
import com.gachaapi.Battle.BattleLog;
import com.gachaapi.Battle.BattleLogEntry;
import com.gachaapi.Entity.Player;

import java.util.List;

public interface PVPService {
    List<Player> getEligibleOpponents(String name);
    BattleLog duel(String attacker, int defender);
    BattleLog duel(String attacker, String defender);
}
