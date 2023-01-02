package com.gachaapi.Controller.game;

import com.gachaapi.Service.interfaces.PlayerArtefactService;
import com.gachaapi.Service.interfaces.PlayerService;
import com.gachaapi.Utils.api.ArtefactLevelUpInfo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;

@Controller
@AllArgsConstructor
public class GameArtefactController {

    private PlayerService playerService;
    private PlayerArtefactService playerArtefactService;

    @GetMapping("/game/equipment/artefacts")
    private String getPlayerEquipmentArtefacts(Model model, Principal principal){
        model.addAttribute("player", playerService.getByName(principal.getName()));
        return "game/equipment/artefacts";
    }

    @PostMapping("/game/equipment/artefacts/level-up")
    private String levelUpPlayerArtefact(Model model, @ModelAttribute ArtefactLevelUpInfo artefactLevelUpInfo, BindingResult bindingResult, Principal principal){
        if (bindingResult.hasErrors()){
            model.addAttribute("player", playerService.getByName(principal.getName()));
            model.addAttribute("error", "Could not find the selected artefact, please try a different one");
            return "game/equipment/artefacts";
        }
        try {
            playerArtefactService.levelUp(artefactLevelUpInfo.getUpgradedArtefactId(), artefactLevelUpInfo.getSacrificedArtefactId(), principal.getName());
        } catch (ResponseStatusException e){
            model.addAttribute("player", playerService.getByName(principal.getName()));
            model.addAttribute("error", e.getReason());
            return "game/equipment/artefacts";
        }
        return "redirect:/game/equipment/artefacts";
    }
}
