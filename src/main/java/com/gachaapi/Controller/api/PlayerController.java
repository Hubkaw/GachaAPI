package com.gachaapi.Controller.api;


import com.gachaapi.Entity.Player;
import com.gachaapi.Service.interfaces.PlayerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;

@Controller
@AllArgsConstructor
public class PlayerController {

    private PlayerService playerService;

    @GetMapping("/api/player-info")
    public ResponseEntity<Player> getPlayerInfo(Principal principal){
        return new ResponseEntity<>(playerService.getByName(principal.getName()), HttpStatus.OK);
    }

    @GetMapping("/api/stamina-exchange/{amount}")
    public ResponseEntity<Player> getStaminaExchange(@PathVariable int amount, Principal principal){
        return ResponseEntity.ok(playerService.buyStaminaForCurrency(amount, principal.getName()));
    }
}
