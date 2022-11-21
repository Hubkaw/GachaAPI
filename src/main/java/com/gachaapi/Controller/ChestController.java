package com.gachaapi.Controller;

import com.gachaapi.Entity.Chest;
import com.gachaapi.Service.interfaces.ChestService;
import com.gachaapi.Utils.ChestReward;
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
public class ChestController {

    private ChestService chestService;


    @GetMapping("/chests")
    public ResponseEntity<List<Chest>> getChests(){
        return new ResponseEntity<>(chestService.getAvailable(), HttpStatus.OK);
    }

    @GetMapping("/chests/all")
    public ResponseEntity<List<Chest>> getAllChests(){
        return new ResponseEntity<>(chestService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/chests/open/{chestId}")
    public ResponseEntity<ChestReward> openChest(Principal principal, @PathVariable("chestId")int chestId){
        ChestReward chestReward = chestService.openChest(principal.getName(), chestId);
        return new ResponseEntity<>(chestReward, HttpStatus.OK);
    }

}
