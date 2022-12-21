package com.gachaapi.Controller.api;


import com.gachaapi.Entity.Player;
import com.gachaapi.Entity.Role;
import com.gachaapi.Service.interfaces.PlayerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class GeneralController {

    private PlayerService playerService;


    @GetMapping("/api/roles")
    public ResponseEntity<List<Role>> getRoles() {
        return new ResponseEntity<>(playerService.getRoles(), HttpStatus.OK);
    }

    @GetMapping("/api/players")
    public ResponseEntity<List<Player>> getPlayers() {
        return new ResponseEntity<>(playerService.getAllPlayers(), HttpStatus.OK);
    }
}
