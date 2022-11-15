package com.gachaapi.Controller;

import com.gachaapi.Entity.Player;
import com.gachaapi.Security.JWTService;
import com.gachaapi.Service.interfaces.PlayerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class SecurityController {

    private final JWTService jwtService;
    private final PlayerService playerService;

    @PostMapping("/login")
    public ResponseEntity<String> token(Authentication authentication){
        if(authentication==null)
            return new ResponseEntity<>("Invalid auth data", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(jwtService.generateToken(authentication),HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<Player> createPlayer(@RequestBody Player newPlayer) {
        return new ResponseEntity<>(playerService.createNewPlayer(newPlayer), HttpStatus.CREATED);
    }

}
