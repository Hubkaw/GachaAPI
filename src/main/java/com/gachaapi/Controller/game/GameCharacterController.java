package com.gachaapi.Controller.game;

import com.gachaapi.Entity.PlayerCharacter;
import com.gachaapi.Service.interfaces.PlayerCharacterService;
import com.gachaapi.Service.interfaces.PlayerService;
import com.gachaapi.Utils.ChangeArtefact;
import com.gachaapi.Utils.WeaponChange;
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
public class GameCharacterController {

    private PlayerService playerService;
    private PlayerCharacterService playerCharacterService;

    @GetMapping("/game/equipment/characters")
    public String getGameEquipmentCharacters(Model model, Principal principal){
        model.addAttribute("player", playerService.getByName(principal.getName()));
        return "game/equipment/characters";
    }

    @GetMapping("/game/equipment/characters/{id}")
    public String getGameCharacterManagement(Model model, @PathVariable int id, Principal principal){
        try {
            model.addAttribute("player", playerService.getByName(principal.getName()));
            model.addAttribute("playerCharacter",playerCharacterService.getSafeById(id, principal.getName()));
            model.addAttribute("totalStats", playerCharacterService.getTotalStats(id, principal.getName()));
            model.addAttribute("costs", playerCharacterService.getLevelUpCosts(id, principal.getName()));
            model.addAttribute("artefacts", playerCharacterService.getCharacterArtefacts(id, principal.getName()));
            model.addAttribute("materialMap", playerService.getMaterialMap(principal.getName()));
            return "game/equipment/character_management";
        } catch (ResponseStatusException e){
            model.addAttribute("player", playerService.getByName(principal.getName()));
            model.addAttribute("error", e.getReason());
            return "game/equipment/characters";
        }
    }

    @PostMapping("/game/equipment/characters/change-weapon")
    public String changeCharacterWeapon(Model model, @ModelAttribute WeaponChange weaponChange, BindingResult result, Principal principal){

        if (result.hasErrors()){
            model.addAttribute("player", playerService.getByName(principal.getName()));
            model.addAttribute("playerCharacter",playerCharacterService.getSafeById(weaponChange.getCharacterId(), principal.getName()));
            model.addAttribute("totalStats", playerCharacterService.getTotalStats(weaponChange.getCharacterId(), principal.getName()));
            model.addAttribute("costs", playerCharacterService.getLevelUpCosts(weaponChange.getCharacterId(), principal.getName()));
            model.addAttribute("artefacts", playerCharacterService.getCharacterArtefacts(weaponChange.getCharacterId(), principal.getName()));
            model.addAttribute("error", "Something went wrong with changing the weapon");
            model.addAttribute("materialMap", playerService.getMaterialMap(principal.getName()));
            return "game/equipment/character_management";
        }
        try {
            playerCharacterService.changeWeapon(weaponChange, principal.getName());
            return "redirect:/game/equipment/characters/"+weaponChange.getCharacterId();
        } catch (ResponseStatusException e){
            model.addAttribute("player", playerService.getByName(principal.getName()));
            model.addAttribute("playerCharacter",playerCharacterService.getSafeById(weaponChange.getCharacterId(), principal.getName()));
            model.addAttribute("error", e.getReason());
            model.addAttribute("materialMap", playerService.getMaterialMap(principal.getName()));
            model.addAttribute("costs", playerCharacterService.getLevelUpCosts(weaponChange.getCharacterId(), principal.getName()));
            model.addAttribute("totalStats", playerCharacterService.getTotalStats(weaponChange.getCharacterId(), principal.getName()));
            model.addAttribute("artefacts", playerCharacterService.getCharacterArtefacts(weaponChange.getCharacterId(), principal.getName()));
            return "game/equipment/character_management";
        }
    }

    @PostMapping("/game/equipment/characters/change-artefact")
    public String changeCharacterArtefact(Model model, @ModelAttribute ChangeArtefact changeArtefact, BindingResult result, Principal principal){
        if (result.hasErrors()){
            model.addAttribute("player", playerService.getByName(principal.getName()));
            model.addAttribute("error", "Something went wrong with changing the weapon");
            model.addAttribute("costs", playerCharacterService.getLevelUpCosts(changeArtefact.getCharacterId(), principal.getName()));
            model.addAttribute("playerCharacter",playerCharacterService.getSafeById(changeArtefact.getCharacterId(), principal.getName()));
            model.addAttribute("totalStats", playerCharacterService.getTotalStats(changeArtefact.getCharacterId(), principal.getName()));
            model.addAttribute("materialMap", playerService.getMaterialMap(principal.getName()));
            model.addAttribute("artefacts", playerCharacterService.getCharacterArtefacts(changeArtefact.getCharacterId(), principal.getName()));
            return "game/equipment/character_management";
        }
        try {
            playerCharacterService.changeArtefact(changeArtefact, principal.getName());
            return "redirect:/game/equipment/characters/"+changeArtefact.getCharacterId();
        } catch (ResponseStatusException e){
            model.addAttribute("player", playerService.getByName(principal.getName()));
            model.addAttribute("playerCharacter",playerCharacterService.getSafeById(changeArtefact.getCharacterId(), principal.getName()));
            model.addAttribute("error", e.getReason());
            model.addAttribute("costs", playerCharacterService.getLevelUpCosts(changeArtefact.getCharacterId(), principal.getName()));
            model.addAttribute("materialMap", playerService.getMaterialMap(principal.getName()));
            model.addAttribute("totalStats", playerCharacterService.getTotalStats(changeArtefact.getCharacterId(), principal.getName()));
            model.addAttribute("artefacts", playerCharacterService.getCharacterArtefacts(changeArtefact.getCharacterId(), principal.getName()));
            return "game/equipment/character_management";
        }
    }

    @GetMapping("/game/equipment/characters/level-up/{id}")
    public String getGameCharacterLevelUp(Model model, @PathVariable int id, Principal principal){
        try {
            model.addAttribute("player", playerService.getByName(principal.getName()));
            model.addAttribute("playerCharacter",playerCharacterService.levelUp(id, principal.getName()));
            model.addAttribute("totalStats", playerCharacterService.getTotalStats(id, principal.getName()));
            model.addAttribute("artefacts", playerCharacterService.getCharacterArtefacts(id, principal.getName()));
            model.addAttribute("costs", playerCharacterService.getLevelUpCosts(id, principal.getName()));
            model.addAttribute("materialMap", playerService.getMaterialMap(principal.getName()));
            return "game/equipment/character_management";
        } catch (ResponseStatusException e){
            model.addAttribute("player", playerService.getByName(principal.getName()));
            model.addAttribute("playerCharacter",playerCharacterService.getSafeById(id, principal.getName()));
            model.addAttribute("costs", playerCharacterService.getLevelUpCosts(id, principal.getName()));
            model.addAttribute("totalStats", playerCharacterService.getTotalStats(id, principal.getName()));
            model.addAttribute("artefacts", playerCharacterService.getCharacterArtefacts(id, principal.getName()));
            model.addAttribute("error", e.getReason());
            model.addAttribute("materialMap", playerService.getMaterialMap(principal.getName()));
            return "game/equipment/character_management";
        }
    }

}
