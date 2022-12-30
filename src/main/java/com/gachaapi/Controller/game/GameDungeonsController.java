package com.gachaapi.Controller.game;

import com.gachaapi.Service.interfaces.ChestService;
import com.gachaapi.Service.interfaces.DungeonService;
import lombok.AllArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor


public class GameDungeonsController {

    private DungeonService dungeonService;

    @GetMapping("/game/dungeons")
    public ModelAndView getDungeons(Model model){
        return new ModelAndView("game/dungeons")
                .addObject("dungeonsList",dungeonService.getAll());
    }

}
