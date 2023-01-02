package com.gachaapi.Controller.game;

import com.gachaapi.Service.interfaces.ChestService;
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


public class GameChestsController {

    private ChestService chestService;
    private PlayerService playerService;

    @GetMapping("/game/chests")
    public ModelAndView getChests(Model model, Principal principal){
        return new ModelAndView("game/chests")
                .addObject("chestList",chestService.getAll())
                .addObject("player",playerService.getByName(principal.getName()));
    }

}


//dopisz service,do model and view dodaj  addobject, chestlist po przecinku [wybranyservice].getall()
// z dev lista, w images dodaj foldery na klasy nazwy zdjec jako IDki