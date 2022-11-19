package com.gachaapi.Controller;


import com.gachaapi.Entity.Player;
import com.gachaapi.Service.interfaces.PlayerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
@AllArgsConstructor
public class PlayerController {

    private PlayerService playerService;

    @GetMapping("/playerInfo")
    public ResponseEntity<Player> getPlayerInfo(Principal principal){
        return new ResponseEntity<>(playerService.getByName(principal.getName()), HttpStatus.OK);
    }
}
