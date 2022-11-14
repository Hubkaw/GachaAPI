package com.gachaapi.Controller;



import com.gachaapi.Entity.Player;
import com.gachaapi.Entity.Role;
import com.gachaapi.Service.interfaces.PlayerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class GeneralController {

    private PlayerService playerService;



@GetMapping("/roles")
public ResponseEntity<List<Role>> getRoles(){
        return new ResponseEntity<>(playerService.getRoles(), HttpStatus.OK);
}

    @GetMapping("/players")
    public ResponseEntity<List<Player>> getPlayers(){
        return new ResponseEntity<>(playerService.getAllPlayers(), HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<Player> createPlayer(@RequestBody Player newPlayer){
        return new ResponseEntity<>(playerService.createNewPlayer(newPlayer), HttpStatus.CREATED);
    }
}
