package com.gachaapi.Controller.api;

import com.gachaapi.Battle.Battle;
import com.gachaapi.Battle.BattleLogEntry;
import com.gachaapi.Service.interfaces.PartyService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;

@RestController
@AllArgsConstructor
public class BattleController {

    private PartyService partyService;

    @GetMapping("/api/battle/{attId}/{defId}")
    public ResponseEntity<List<BattleLogEntry>> getBattle(@PathVariable("attId") int attId, @PathVariable("defId")int defId){
        return ResponseEntity.ok(Battle.simulate(partyService.getById(attId), partyService.getById(defId)));
    }
}
