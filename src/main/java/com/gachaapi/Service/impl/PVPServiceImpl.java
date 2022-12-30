package com.gachaapi.Service.impl;

import com.gachaapi.Battle.Battle;
import com.gachaapi.Battle.BattleLogEntry;
import com.gachaapi.Entity.Party;
import com.gachaapi.Entity.Player;
import com.gachaapi.Repository.PartyRepository;
import com.gachaapi.Repository.PlayerRepository;
import com.gachaapi.Service.interfaces.PVPService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PVPServiceImpl implements PVPService {

    private PlayerRepository playerRepository;
    private PartyRepository partyRepository;


    @Override
    public List<Player> getEligibleOpponents(String name) {
        Player player = playerRepository.findByNick(name).orElseThrow();
        double minimalEloPoints = player.getEloPoints() * 0.8;
        return playerRepository.findAllByEloPointsGreaterThanEqualAndActivePartyIsNot((int) minimalEloPoints, 0);
    }

    @Override
    public List<BattleLogEntry> duel(String attackerName, int defenderId) {
        Player attacker = playerRepository.findByNick(attackerName).orElseThrow();
        Player defender = playerRepository.findById(defenderId).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.BAD_REQUEST, "This player does not exist."));
        if (attacker.getActiveParty() < 1){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You have no active party.");
        }
        if (defender.getActiveParty() < 1){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Opponent has no active party.");
        }
        if (attacker.getEloPoints()*0.8 > defender.getEloPoints()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Opponent's ELO is too low for you.");
        }
        Party attackerParty = partyRepository.findById(attacker.getActiveParty()).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.BAD_REQUEST, "Your active party is invalid."));
        if (attackerParty.getCharacters().size() != 4){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Your active party is invalid.");
        }
        Party defenderParty = partyRepository.findById(defender.getActiveParty()).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.BAD_REQUEST, "Opponent's active party is invalid."));
        if (defenderParty.getCharacters().size() !=4){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Opponent's active party is invalid.");
        }

        List<BattleLogEntry> sim = Battle.simulate(attackerParty, defenderParty);
        // TODO save battle log to db
        return sim;
    }
}
