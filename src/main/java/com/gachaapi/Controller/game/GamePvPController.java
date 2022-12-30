package com.gachaapi.Controller.game;

import com.gachaapi.Service.interfaces.ChestService;
import com.gachaapi.Service.interfaces.PVPService;
import lombok.AllArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor


public class GamePvPController {

    //how to get enemies
    private PVPService pvpService;

    @GetMapping("/game/pvp")
    public ModelAndView getPvPSelection(Model model){
        return new ModelAndView("game/pvp_selection");
    }

}


//dopisz service,do model and view dodaj  addobject, chestlist po przecinku [wybranyservice].getall()
// z dev lista, w images dodaj foldery na klasy nazwy zdjec jako IDki