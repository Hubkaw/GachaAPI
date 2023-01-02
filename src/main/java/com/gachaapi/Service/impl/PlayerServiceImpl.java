package com.gachaapi.Service.impl;

import com.gachaapi.Entity.Player;
import com.gachaapi.Entity.PlayerMaterial;
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

import javax.ejb.Local;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

import static com.gachaapi.Utils.Constants.DEFAULT_STAMINA_AMOUNT;
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
    public Player createNewPlayer(NewPlayer newPlayer){
        Timestamp birthDate = validateNewPlayer(newPlayer);
        if (playerRepository.existsByNick(newPlayer.getNick())){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Nickname already used");
        }
        System.out.println(newPlayer.getNick());
        System.out.println(newPlayer.getBirthDate());
        Player player = new Player();
        player.setNick(newPlayer.getNick());
        player.setHashedPassword(passwordEncoder.encode(newPlayer.getPassword()));
        player.setRoles(new HashSet<>());
        player.getRoles().add(roleRepository.findByName(USER_ROLE));
        player.setBirthDate(birthDate);
        player.setEloPoints(1500);
        player.setJoinDate(Timestamp.valueOf(LocalDateTime.now()));
        player.setActiveParty(0);
        player.setPremiumLeft(0);
        player.setStamina(DEFAULT_STAMINA_AMOUNT);
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

    private Timestamp validateNewPlayer(NewPlayer player){
        if (player.getNick() == null || player.getNick().isBlank() || player.getNick().contains("/") || player.getNick().contains(";") || player.getNick().contains("%") || player.getNick().length() >=32){
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid nickname.");
        }
        if (player.getPassword() == null || player.getPassword().isBlank() || player.getPassword().contains("/") || player.getPassword().contains(";") || player.getPassword().contains("%") || player.getPassword().length()>64){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid password");
        }
        Timestamp timestamp;
        try {
            timestamp = Timestamp.from(new SimpleDateFormat("yyyy-MM-dd").parse(player.getBirthDate()).toInstant());
        } catch (ParseException parseException) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Incorrect date.");
        }
        if (timestamp.after(Timestamp.valueOf(LocalDateTime.now().minus(13, ChronoUnit.YEARS)))){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You are too young to create an account.");
        }
        return timestamp;
    }

    public Map<String, Integer> getMaterialMap(String nickname){
        Player player = playerRepository.findByNick(nickname).orElseThrow();
        Map<String, Integer> result = new HashMap<>();
        for (PlayerMaterial pm : player.getPlayerMaterials()) {
            result.put(pm.getMaterial().getName(), pm.getAmount());
        }
        return result;
    }
}
