package com.gachaapi.Service.interfaces;


import com.gachaapi.Model.Player;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PlayerService {
    List<Player> getAllPlayers();
}
