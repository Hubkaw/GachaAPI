package com.gachaapi.Service.interfaces;


import com.gachaapi.Entity.Player;
import com.gachaapi.Entity.Role;

import java.util.List;


public interface PlayerService {
    List<Player> getAllPlayers();
    Player createNewPlayer(Player newPlayer);
    List<Role> getRoles();
}
