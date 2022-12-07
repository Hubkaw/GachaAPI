package com.gachaapi.Controller;

import com.gachaapi.Entity.Character;
import com.gachaapi.Service.interfaces.CharacterService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class CharacterController {

    private CharacterService characterService;

    @GetMapping("/characters")
    public ResponseEntity<List<Character>> getCharacters(){
        return new ResponseEntity<>(characterService.getAll(), HttpStatus.OK);
    }
}
