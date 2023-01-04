package com.gachaapi.Controller.game;

import com.gachaapi.Service.interfaces.ChestService;
import com.gachaapi.Service.interfaces.PVPService;
import com.gachaapi.Service.interfaces.PlayerService;
import lombok.AllArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@AllArgsConstructor


public class GamePvPController {

    //how to get enemies
    private PlayerService playerService;
    private PVPService pvpService;

    @GetMapping("/game/pvp")
    public String getPvPSelection(Model model, Principal principal){
        model.addAttribute("player", playerService.getByName(principal.getName()));
        model.addAttribute("opponents", pvpService.getEligibleOpponents(principal.getName()));
        return "game/pvp_selection";
    }

    @GetMapping("/game/pvp/duel/{nick}")
    public String getPvPDuel(Model model, @PathVariable String nick, Principal principal){
        try {
            model.addAttribute("log", pvpService.duel(principal.getName(), nick).getLog());
            model.addAttribute("player", playerService.getByName(principal.getName()));
            return "game/pvp_duel";
        } catch (ResponseStatusException e){
            model.addAttribute("player", playerService.getByName(principal.getName()));
            model.addAttribute("opponents", pvpService.getEligibleOpponents(principal.getName()));
            model.addAttribute("error", e.getReason());
            return "game/pvp_selection";
        }
    }

}


//dopisz service,do model and view dodaj  addobject, chestlist po przecinku [wybranyservice].getall()
// z dev lista, w images dodaj foldery na klasy nazwy zdjec jako IDki