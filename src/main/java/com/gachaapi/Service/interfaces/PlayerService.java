package com.gachaapi.Service.interfaces;


import com.gachaapi.Entity.Player;
import com.gachaapi.Entity.Role;
import com.gachaapi.Utils.NewPlayer;
import com.gachaapi.Utils.PremiumRewards;

import java.text.ParseException;
import java.util.List;
import java.util.Map;


public interface PlayerService {
    List<Player> getAllPlayers();
    Player createNewPlayer(NewPlayer newPlayer);
    List<Role> getRoles();
    Player getByName(String nick);

    Map<String, Integer> getMaterialMap(String nick);

    PremiumRewards getPremiumRewards(String nick);
}
