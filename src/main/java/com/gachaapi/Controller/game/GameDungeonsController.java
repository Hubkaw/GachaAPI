package com.gachaapi.Controller.game;

import com.gachaapi.Service.interfaces.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;
import java.security.Principal;

@Controller
@AllArgsConstructor


public class GameDungeonsController {

    private DungeonService dungeonService;
    private PlayerService playerService;

    private PartyService partyService;

    private BattleLogsService battleLogsService;

    @GetMapping("/game/dungeons")
    public ModelAndView getDungeons(Model model, Principal principal){
        return new ModelAndView("game/dungeons")
                .addObject("dungeonsList",dungeonService.getAll())
                .addObject("player",playerService.getByName(principal.getName()));


    }


    @GetMapping("/game/dungeons/{floorId}")
    public ModelAndView getDungeonDetails(Model model, @PathVariable(value="floorId") int id,Principal principal){
        return new ModelAndView("game/dungeonDetails")
                .addObject("player",playerService.getByName(principal.getName()))
                .addObject("dungeonDetails",dungeonService.getById(id))
        .addObject("playerParty",partyService.getById(playerService.getByName(principal.getName()).getActiveParty()));
    }

    @GetMapping("/game/enter-dungeon/{floorId}")
    public ModelAndView enterDungeon(@PathVariable int floorId, Principal principal){
        try {
            return new ModelAndView("game/dungeonResult").
                    addObject("player", playerService.getByName(principal.getName())).
                    addObject("result", dungeonService.enterDungeon(floorId, principal.getName()));
        } catch (ResponseStatusException e){
            return new ModelAndView("game/dungeons")
                    .addObject("dungeonsList",dungeonService.getAll())
                    .addObject("player",playerService.getByName(principal.getName()))
                    .addObject("error", e.getReason());
        }

    }


}
