package com.gachaapi.Controller.game;

import com.gachaapi.Service.interfaces.PlayerService;
import com.gachaapi.Utils.StaminaExchange;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

import static com.gachaapi.Utils.Constants.BALANCE_TO_STAMINA_EXCHANGE_RATIO;

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

    @GetMapping("/game/stamina-exchange")
    public String getStaminaExchange(Model model, Principal principal){
        model.addAttribute("player", playerService.getByName(principal.getName()));
        model.addAttribute("ratio", BALANCE_TO_STAMINA_EXCHANGE_RATIO);
        return "game/stamina-exchange";
    }

    @PostMapping("/game/stamina-exchange")
    public String exchangeStamina(Model model, @ModelAttribute StaminaExchange se, BindingResult result, Principal principal){
        if (result.hasErrors()){
            model.addAttribute("error", "A problem occurred with your request, please ty again later");
            model.addAttribute("player", playerService.getByName(principal.getName()));
            return "game/stamina-exchange";
        }
        try {
            model.addAttribute("player", playerService.buyStaminaForCurrency(se.getAmount(), principal.getName()));
            return "game/stamina-exchange";
        } catch (ResponseStatusException e){
            model.addAttribute("error", e.getReason());
            model.addAttribute("player", playerService.getByName(principal.getName()));
            return "game/stamina-exchange";
        }
    }

}
