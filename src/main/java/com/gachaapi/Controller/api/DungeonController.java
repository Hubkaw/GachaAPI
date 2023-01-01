package com.gachaapi.Controller.api;

import com.gachaapi.Entity.Dungeon;
import com.gachaapi.Service.interfaces.DungeonService;
import com.gachaapi.Utils.PvEResult;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;
import java.util.List;

@Controller
@AllArgsConstructor
public class DungeonController {

    private DungeonService dungeonService;

    @GetMapping("/api/dungeons")
    public ResponseEntity<List<Dungeon>> getDungeons(){
        return new ResponseEntity<>(dungeonService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/api/dungeon/{id}")
    public ResponseEntity<Dungeon> getDungeon(@PathVariable int id){
        return ResponseEntity.ok(dungeonService.getById(id));
    }

    @GetMapping("/api/enter-dungeon/{floorId}")
    public ResponseEntity<PvEResult> enterDungeon(@PathVariable int floorId, Principal principal){
        return ResponseEntity.ok(dungeonService.enterDungeon(floorId, principal.getName()));
    }

    @GetMapping("/api/enter-dungeon/{floorId}/{partyId}")
    public ResponseEntity<PvEResult> enterDungeon(@PathVariable int floorId,@PathVariable int partyId, Principal principal){
        return ResponseEntity.ok(dungeonService.enterDungeon(floorId, partyId, principal.getName()));
    }

}
