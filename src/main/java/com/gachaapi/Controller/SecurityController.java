package com.gachaapi.Controller;

import com.gachaapi.Entity.Player;
import com.gachaapi.Utils.NewPlayer;
import com.gachaapi.Security.Service.JWTService;
import com.gachaapi.Service.interfaces.PlayerService;
import com.gachaapi.Utils.TokenResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@AllArgsConstructor
public class SecurityController {

    private final JWTService jwtService;
    private final PlayerService playerService;

    @GetMapping("/login")
    public ResponseEntity<TokenResponse> token(Authentication authentication){
        if(authentication==null)
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        return new ResponseEntity<>(new TokenResponse(jwtService.generateToken(authentication), "Bearer"),HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<Player> createPlayer(@RequestBody NewPlayer newPlayer) {
        return new ResponseEntity<>(playerService.createNewPlayer(newPlayer), HttpStatus.CREATED);
    }

}
