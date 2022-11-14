package com.gachaapi.Service.impl;

import com.gachaapi.Entity.Player;
import com.gachaapi.Entity.Role;
import com.gachaapi.Repository.PlayerRepository;
import com.gachaapi.Repository.RoleRepository;
import com.gachaapi.Service.interfaces.PlayerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;

import static com.gachaapi.Service.Constants.USER_ROLE;

@Service
@AllArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    private PlayerRepository playerRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @Override
    public Player createNewPlayer(Player newPlayer) {
        if (!validateNewPlayer(newPlayer)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Data");
        }
        if (playerRepository.existsByNick(newPlayer.getNick())){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Nickname already used");
        }
        Player player = new Player();
        player.setNick(newPlayer.getNick());
        player.setHashedPassword(passwordEncoder.encode(newPlayer.getHashedPassword()));
        player.setRoles(new HashSet<>());
        player.getRoles().add(roleRepository.findByName(USER_ROLE));
        player.setBirthDate(Timestamp.valueOf("1998-01-01 01:01:01"));
        player.setEloPoints(0);
        player.setJoinDate(Timestamp.valueOf(LocalDateTime.now()));
        player.setPvpLooses(0);
        player.setPvpWins(0);
        player.setPityRollStatus(0);
        player.setPlayerBalance(0);
        playerRepository.save(player);

        return null;
    }

    @Override
    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

    private boolean validateNewPlayer(Player player) {
        System.out.println(player);
        return player != null
                && player.getNick() != null
                && player.getHashedPassword() != null
                && player.getNick().length() <= 32
                && !player.getNick().contains("/")
                && !player.getNick().contains(";")
                && !player.getHashedPassword().contains(";")
                && !player.getHashedPassword().contains("/");
    }
}
