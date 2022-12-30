package com.gachaapi.Controller.api;


import com.gachaapi.Battle.BattleLogEntry;
import com.gachaapi.Entity.Player;
import com.gachaapi.Repository.PartyRepository;
import com.gachaapi.Repository.PlayerRepository;
import com.gachaapi.Service.interfaces.PVPService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@AllArgsConstructor
public class PvPController {

    private PVPService pvpService;


    @GetMapping("/api/pvp")
    public ResponseEntity<List<Player>> getPvpOpponents(Principal principal){
        return ResponseEntity.ok(pvpService.getEligibleOpponents(principal.getName()));
    }

    @GetMapping("/api/pvp/duel/{id}")
    public ResponseEntity<List<BattleLogEntry>> duel(Principal principal, @PathVariable("id") int id){
        return ResponseEntity.ok(pvpService.duel(principal.getName(), id));
    }
}
