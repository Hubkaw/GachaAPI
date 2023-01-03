package com.gachaapi.Controller.game;

import com.gachaapi.Service.interfaces.PartyService;
import com.gachaapi.Service.interfaces.PlayerPartyService;
import com.gachaapi.Service.interfaces.PlayerService;
import com.gachaapi.Utils.PartyCharacterChange;
import com.gachaapi.Utils.api.NewParty;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;

@Controller
@AllArgsConstructor
public class GamePartyController {

    private PlayerService playerService;
    private PlayerPartyService playerPartyService;

    @GetMapping("/game/equipment/parties")
    public String getGameParties(Model model, Principal principal){
        model.addAttribute("player", playerService.getByName(principal.getName()));
        return "game/equipment/parties";
    }

    @PostMapping("/game/equipment/parties/change-character")
    public String changePartyCharacter(Model model, @ModelAttribute PartyCharacterChange pcc, BindingResult result, Principal principal){
        if(result.hasErrors()){
            model.addAttribute("player", playerService.getByName(principal.getName()));
            model.addAttribute("error", "There was a problem with changing party character");
            return "game/equipment/parties";
        }
        try {
            playerPartyService.changePartyCharacter(pcc, principal.getName());
            return "redirect:/game/equipment/parties";
        } catch (ResponseStatusException e){
            model.addAttribute("player", playerService.getByName(principal.getName()));
            model.addAttribute("error", e.getReason());
            return "game/equipment/parties";
        }
    }

    @GetMapping("/game/equipment/parties/set-active/{id}")
    public String setGameActiveParty(Model model, @PathVariable int id, Principal principal){
        try {
            playerPartyService.setActive(id, principal.getName());
            return "redirect:/game/equipment/parties";
        } catch (ResponseStatusException e){
            model.addAttribute("player", playerService.getByName(principal.getName()));
            model.addAttribute("error", e.getReason());
            return "game/equipment/parties";
        }
    }

    @PostMapping("/game/equipment/parties/new-party")
    public String createNewPlayerParty(Model model, @ModelAttribute NewParty newParty,BindingResult result , Principal principal){
        if (result.hasErrors()){
            model.addAttribute("player", playerService.getByName(principal.getName()));
            model.addAttribute("error", "There was a problem creating your party");
            return "game/equipment/parties";
        }
        try {
            playerPartyService.createParty(newParty, principal.getName());
            return "redirect:/game/equipment/parties";
        } catch (ResponseStatusException e){
            model.addAttribute("player", playerService.getByName(principal.getName()));
            model.addAttribute("error", e.getReason());
            return "game/equipment/parties";
        }
    }





}
