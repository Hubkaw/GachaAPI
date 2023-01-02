package com.gachaapi.Controller.game;

import com.gachaapi.Service.interfaces.PlayerService;
import com.gachaapi.Service.interfaces.PlayerWeaponService;
import com.gachaapi.Service.interfaces.WeaponService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;

@Controller
@AllArgsConstructor
public class GameWeaponController {

    private PlayerService playerService;
    private PlayerWeaponService playerWeaponService;

    @GetMapping("/game/equipment/weapons")
    public String getGameEquipmentWeapons(Model model, Principal principal){
        model.addAttribute("player", playerService.getByName(principal.getName()));
        model.addAttribute("materialMap", playerService.getMaterialMap(principal.getName()));
        return "game/equipment/weapons";
    }

    @GetMapping("/game/equipment/weapons/level-up/{id}")
    public String levelUpEquipmentWeapon(Model model, @PathVariable int id, Principal principal){
        try {
            playerWeaponService.levelUp(id, principal.getName());
        } catch (ResponseStatusException e){
            model.addAttribute("player", playerService.getByName(principal.getName()));
            model.addAttribute("materialMap", playerService.getMaterialMap(principal.getName()));
            model.addAttribute("error", e.getReason());
            return "game/equipment/weapons";
        }
        return "redirect:/game/equipment/weapons";
    }
}
