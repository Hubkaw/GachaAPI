package com.gachaapi.Service.impl;

import com.gachaapi.Entity.Player;
import com.gachaapi.Entity.Role;
import com.gachaapi.Repository.PlayerRepository;
import com.gachaapi.Repository.RoleRepository;
import com.gachaapi.Utils.NewPlayer;
import com.gachaapi.Service.interfaces.PlayerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.List;

import static com.gachaapi.Utils.Constants.USER_ROLE;

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
    public Player createNewPlayer(NewPlayer newPlayer) {
        if (!validateNewPlayer(newPlayer)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid login or password");
        }
        if (playerRepository.existsByNick(newPlayer.getNick())){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Nickname already used");
        }
        Player player = new Player();
        player.setNick(newPlayer.getNick());
        player.setHashedPassword(passwordEncoder.encode(newPlayer.getPassword()));
        player.setRoles(new HashSet<>());
        player.getRoles().add(roleRepository.findByName(USER_ROLE));
        player.setBirthDate(Timestamp.valueOf(LocalDateTime.now().minus(20, ChronoUnit.YEARS)));
        player.setEloPoints(0);
        player.setJoinDate(Timestamp.valueOf(LocalDateTime.now()));
        player.setPvpLooses(0);
        player.setPvpWins(0);
        player.setPityRollStatus(0);
        player.setPlayerBalance(0);
        playerRepository.save(player);

        return player;
    }

    @Override
    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Player getByName(String nick) {
        return playerRepository.findByNick(nick).orElseThrow(() -> new UsernameNotFoundException("Invalid username"));
    }

    private boolean validateNewPlayer(NewPlayer player) {
        System.out.println(player);
        return player != null
                && player.getNick() != null
                && player.getPassword() != null
                && player.getNick().length() <= 32
                && !player.getNick().contains("/")
                && !player.getNick().contains(";")
                && !player.getPassword().contains(";")
                && !player.getPassword().contains("/");
    }
}
