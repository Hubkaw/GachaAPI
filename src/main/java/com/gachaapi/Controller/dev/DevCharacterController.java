package com.gachaapi.Controller.dev;


import com.gachaapi.Service.interfaces.*;
import com.gachaapi.Utils.dev.NewCharacter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@AllArgsConstructor
@Controller
public class DevCharacterController {

    private CharacterService characterService;
    private RarityService rarityService;
    private ClassService classService;
    private AffiliationService affiliationService;
    private StatisticService statisticService;

    @GetMapping("/dev/character")
    public String getCharacter(Model model){
        model.addAttribute("characterList", characterService.getAll());
        model.addAttribute("rarityList", rarityService.getAll());
        model.addAttribute("classList", classService.getAll());
        model.addAttribute("affiliationList", affiliationService.getAll());
        model.addAttribute("statList", statisticService.getAll());
        return "dev/character";
    }

    @PostMapping("/dev/character")
    public String createCharacter(Model model, @ModelAttribute("newCharacter") NewCharacter newCharacter){
        characterService.create(newCharacter);
        return "redirect:/dev/character";
    }

    @GetMapping("/dev/character/delete/{id}")
    public String deleteCharacter(Model model, @PathVariable("id")int id){
        characterService.delete(id);
        return "redirect:/dev/character";
    }


}
