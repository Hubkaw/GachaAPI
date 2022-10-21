package com.gachaapi.Controller;


import com.gachaapi.Model.Player;
import com.gachaapi.Service.interfaces.PlayerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GeneralController {

    private PlayerService playerService;

    public GeneralController(PlayerService playerService){
        this.playerService = playerService;
    }

    @GetMapping("/players")
    public ResponseEntity<List<Player>> getPlayers(){
        return new ResponseEntity<>(playerService.getAllPlayers(), HttpStatus.OK);
    }
}
