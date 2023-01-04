package com.gachaapi.Service.impl;

import com.gachaapi.Battle.*;
import com.gachaapi.Entity.BattleHistory;
import com.gachaapi.Utils.BattleType;
import com.gachaapi.Entity.Party;
import com.gachaapi.Entity.Player;
import com.gachaapi.Repository.BattleLogRepository;
import com.gachaapi.Repository.PartyRepository;
import com.gachaapi.Repository.PlayerRepository;
import com.gachaapi.Service.interfaces.PVPService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class PVPServiceImpl implements PVPService {

    private PlayerRepository playerRepository;
    private PartyRepository partyRepository;
    private BattleLogRepository battleLogRepository;


    @Override
    public List<Player> getEligibleOpponents(String name) {
        Player player = playerRepository.findByNick(name).orElseThrow();
        double minimalEloPoints = player.getEloPoints() * 0.8;
        return playerRepository.findAllByEloPointsGreaterThanEqualAndActivePartyIsNot((int) minimalEloPoints, 0);
    }

    @Override
    public BattleLog duel(String attackerName, int defenderId) {
        Player attacker = playerRepository.findByNick(attackerName).orElseThrow();
        if (attacker.getIdPlayer() == defenderId){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You cannot duel yourself.");
        }
        Player defender = playerRepository.findById(defenderId).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.BAD_REQUEST, "This player does not exist."));
        if (attacker.getActiveParty() < 1) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You have no active party.");
        }
        if (defender.getActiveParty() < 1) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Opponent has no active party.");
        }
        if (attacker.getEloPoints() * 0.8 > defender.getEloPoints()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Opponent's ELO is too low for you.");
        }
        Party attackerParty = partyRepository.findById(attacker.getActiveParty()).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.BAD_REQUEST, "Your active party is invalid."));
        if (attackerParty.getCharacters().size() != 4) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Your active party is invalid.");
        }
        Party defenderParty = partyRepository.findById(defender.getActiveParty()).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.BAD_REQUEST, "Opponent's active party is invalid."));
        if (defenderParty.getCharacters().size() != 4) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Opponent's active party is invalid.");
        }

        BattleLog sim = Battle.simulate(attackerParty, defenderParty);

        double Ra = attacker.getEloPoints();
        double Rd = defender.getEloPoints();

        double Ea = 1 / (1 + Math.pow(10.0, ((Ra - Rd) / 400.0)));
        double Ed = 1 / (1 + Math.pow(10.0, ((Rd - Ra) / 400.0)));

        double Sa;
        double Sd;
        if (sim.getWinner() == Side.ATTACKER) {
            Sa = 1;
            Sd = 0;
        } else {
            Sa = 0;
            Sd = 1;
        }
        double Rpa = Ra + (26 * (Sa - Ea));
        double Rpd = Rd + (26 * (Sd - Ed));
        attacker.setEloPoints((int) Rpa);
        defender.setEloPoints((int) Rpd);
        playerRepository.save(attacker);
        playerRepository.save(defender);

        BattleHistory battleHistory = new BattleHistory();
        battleHistory.setLog(sim);
        battleHistory.setType(BattleType.PvP);
        battleHistory.setAttacker(attacker);
        battleHistory.setDefender(defender);
        battleLogRepository.save(battleHistory);

        return sim;
    }

    @Override
    public BattleLog duel(String attacker, String defender) {
        Player def = playerRepository.findByNick(defender).orElseThrow(() ->
            new ResponseStatusException(HttpStatus.NOT_FOUND, "Opponent not found")
        );
        return duel(attacker, def.getIdPlayer());
    }


}
