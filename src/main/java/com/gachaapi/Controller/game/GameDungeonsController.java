package com.gachaapi.Controller.game;

import com.gachaapi.Service.interfaces.ChestService;
import com.gachaapi.Service.interfaces.DungeonService;
import com.gachaapi.Service.interfaces.PlayerService;
import lombok.AllArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@AllArgsConstructor


public class GameDungeonsController {

    private DungeonService dungeonService;
    private PlayerService playerService;

    @GetMapping("/game/dungeons")
    public ModelAndView getDungeons(Model model, Principal principal){
        return new ModelAndView("game/dungeons")
                .addObject("dungeonsList",dungeonService.getAll())
                .addObject("player",playerService.getByName(principal.getName()));

    }

}
