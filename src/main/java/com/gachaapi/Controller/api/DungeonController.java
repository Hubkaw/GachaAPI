package com.gachaapi.Controller.api;

import com.gachaapi.Entity.Dungeon;
import com.gachaapi.Service.interfaces.DungeonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class DungeonController {

    private DungeonService dungeonService;

    @GetMapping("/api/dungeons")
    public ResponseEntity<List<Dungeon>> getDungeons(){
        return new ResponseEntity<>(dungeonService.getAll(), HttpStatus.OK);
    }

}
