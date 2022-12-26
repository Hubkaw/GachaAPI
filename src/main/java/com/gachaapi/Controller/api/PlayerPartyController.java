package com.gachaapi.Controller.api;


import com.gachaapi.Entity.Party;
import com.gachaapi.Service.interfaces.PlayerPartyService;
import com.gachaapi.Utils.api.NewParty;
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
public class PlayerPartyController {

    private PlayerPartyService playerPartyService;

    @GetMapping("/api/player/parties")
    public ResponseEntity<List<Party>> getParties(Principal principal){
        return ResponseEntity.ok(playerPartyService.getAll(principal.getName()));
    }
    @PostMapping("/api/player/parties")
    public ResponseEntity<Party> createParty(@RequestBody NewParty newParty, Principal principal){
        return ResponseEntity.ok(playerPartyService.createParty(newParty, principal.getName()));
    }
    @GetMapping("/api/player/parties/delete/{id}")
    public ResponseEntity<String> deleteParty(@PathVariable("id")int id, Principal principal){
        playerPartyService.deleteParty(id, principal.getName());
        return ResponseEntity.ok("Party deleted");
    }
}
