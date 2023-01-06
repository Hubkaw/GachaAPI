package com.gachaapi.Controller.game;

import com.gachaapi.Service.interfaces.ChestService;
import com.gachaapi.Service.interfaces.PlayerService;
import com.gachaapi.Utils.ChestReward;
import lombok.AllArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
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
                .addObject("chestList",chestService.getAvailable())
                .addObject("player",playerService.getByName(principal.getName()));
    }

    @GetMapping("/game/chests/{someID}")
    public ModelAndView getChestDetails(Model model, @PathVariable(value="someID") int id,Principal principal){
        return new ModelAndView("game/chestDetails")
                .addObject("player",playerService.getByName(principal.getName()))
                .addObject("chestDetails",chestService.getById(id))
                .addObject("chestWeapons",chestService.getAllWeapons(id))
                .addObject("chestCharacters",chestService.getAllCharacters(id));
    }

    @GetMapping("/game/chests/open/{id}")
    public String getOpenChest(Model model,@PathVariable int id, Principal principal){
        try {
            model.addAttribute("reward",chestService.openChest(principal.getName(), id));
            model.addAttribute("player", playerService.getByName(principal.getName()));
            model.addAttribute("chestId", id);
            return "game/chest_reward";
        } catch (ResponseStatusException e){
            model.addAttribute("chestList",chestService.getAvailable());
            model.addAttribute("player",playerService.getByName(principal.getName()));
            model.addAttribute("error", e.getReason());
            return "game/chests";
        }
    }


}



//dopisz service,do model and view dodaj  addobject, chestlist po przecinku [wybranyservice].getall()
// z dev lista, w images dodaj foldery na klasy nazwy zdjec jako IDki