package com.gachaapi.Controller.api;

import com.gachaapi.Entity.PlayerCharacter;
import com.gachaapi.Service.interfaces.PlayerCharacterService;
import com.gachaapi.Utils.api.CharacterEquipment;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.security.Principal;
import java.util.List;

@Controller
@AllArgsConstructor
public class PlayerCharacterController {

    private PlayerCharacterService playerCharacterService;

    @GetMapping("/api/player/characters")
    public ResponseEntity<List<PlayerCharacter>> getPlayerCharacters(Principal principal){
        return ResponseEntity.ok(playerCharacterService.getPlayerCharacters(principal.getName()));
    }

    @PostMapping("/api/player/characters/equipment")
    public ResponseEntity<PlayerCharacter> setCharacterEquipment(@RequestBody CharacterEquipment ce, Principal principal){
        return ResponseEntity.ok(playerCharacterService.changeCharacterEquipment(ce, principal.getName()));
    }

    @GetMapping("/api/player/characters/levelUp/{id}")
    public ResponseEntity<PlayerCharacter> levelUpCharacter(@PathVariable("id")int characterId, Principal principal){
        return ResponseEntity.ok(playerCharacterService.levelUp(characterId, principal.getName()));
    }
}
