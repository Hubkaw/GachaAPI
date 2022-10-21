package com.gachaapi.Service.impl;

import com.gachaapi.Model.Player;
import com.gachaapi.Repository.PlayerRepository;
import com.gachaapi.Service.interfaces.PlayerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    public PlayerServiceImpl(PlayerRepository playerRepository){
        this.playerRepository = playerRepository;
    }

    private PlayerRepository playerRepository;

    @Override
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }
}
