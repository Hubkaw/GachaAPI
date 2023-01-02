package com.gachaapi.Controller.dev;

import com.gachaapi.Service.interfaces.RarityService;
import com.gachaapi.Utils.dev.NewRarity;
import lombok.AllArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@AllArgsConstructor
@Controller
public class DevRarityController {

    private RarityService rarityService;

    @GetMapping("/dev/rarity")
    public String getRarity(Model model){
        model.addAttribute("rarityList", rarityService.getAll());
        return "dev/Rarity";
    }

    @PostMapping("/dev/rarity")
    public String createRarity(Model model, @ModelAttribute("newRarity")NewRarity newRarity){
        rarityService.create(newRarity);
        return "redirect:/dev/rarity";
    }

    @GetMapping("/dev/rarity/delete/{id}")
    public String deleteRarity(Model model, @PathVariable("id")int id){
        rarityService.delete(id);
        return "redirect:/dev/rarity";
    }
}
