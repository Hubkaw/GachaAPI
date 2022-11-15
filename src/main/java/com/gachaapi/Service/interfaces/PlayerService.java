package com.gachaapi.Service.interfaces;


import com.gachaapi.Entity.Player;
import com.gachaapi.Entity.Role;
import com.gachaapi.RequestBody.NewPlayer;

import java.util.List;


public interface PlayerService {
    List<Player> getAllPlayers();
    Player createNewPlayer(NewPlayer newPlayer);
    List<Role> getRoles();
}
