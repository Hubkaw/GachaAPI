package com.gachaapi.Controller.game;

import com.gachaapi.Service.interfaces.HomeService;
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
public class GameHomeController {

    private PlayerService playerService;

    @GetMapping("/game/home")
    public ModelAndView getHome(Model model, Principal principal){
        return new ModelAndView("game/home")
                .addObject("premiumRewards", playerService.getPremiumRewards(principal.getName()))
                .addObject("player",playerService.getByName(principal.getName()));
    }

}
