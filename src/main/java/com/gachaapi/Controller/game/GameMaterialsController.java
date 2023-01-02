package com.gachaapi.Controller.game;

import com.gachaapi.Service.interfaces.PlayerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
@AllArgsConstructor
public class GameMaterialsController {

    private PlayerService playerService;

    @GetMapping("/game/equipment/materials")
    public String getPlayerEquipmentMaterials(Model model, Principal principal){
        model.addAttribute("player", playerService.getByName(principal.getName()));
        return "game/equipment/materials";
    }
}
