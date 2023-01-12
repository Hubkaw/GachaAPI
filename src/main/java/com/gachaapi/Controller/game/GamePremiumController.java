package com.gachaapi.Controller.game;

import com.gachaapi.Service.interfaces.PlayerService;
import com.gachaapi.Service.interfaces.PremiumService;
import com.gachaapi.Utils.PremiumBuyOrder;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;

import static com.gachaapi.Utils.Constants.PREMIUM_DAY_PRICE;

@Controller
@AllArgsConstructor
public class GamePremiumController {

    private PremiumService premiumService;
    private PlayerService playerService;

    @GetMapping("/game/premium")
    private String getPremiumShop(Model model, Principal principal){
        model.addAttribute("player", playerService.getByName(principal.getName()));
        model.addAttribute("price", PREMIUM_DAY_PRICE);
        return "game/premium";
    }

    @PostMapping("/game/premium")
    private String buyGamePremium(Model model, @ModelAttribute PremiumBuyOrder order, BindingResult result, Principal principal){
        if (result.hasErrors()){
            model.addAttribute("player", playerService.getByName(principal.getName()));
            model.addAttribute("price", PREMIUM_DAY_PRICE);
            model.addAttribute("error", "There was a problem with your purchase");
            return "game/premium";
        }
        try{
            premiumService.buyPremium(principal.getName(), order.getAmount());
            return "redirect:/game/home";
        }catch (ResponseStatusException e){
            model.addAttribute("player", playerService.getByName(principal.getName()));
            model.addAttribute("price", PREMIUM_DAY_PRICE);
            model.addAttribute("error", e.getReason());
            return "game/premium";
        }
    }

}
