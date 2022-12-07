package com.gachaapi.Controller.dev;

import com.gachaapi.Utils.dev.DevMenuRecord;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import static java.util.Arrays.asList;

@AllArgsConstructor
@Controller
public class DevMenuController {

    private static final List<DevMenuRecord> NAV_LINKS = asList(
            new DevMenuRecord("Menu", "/dev/menu"),
            new DevMenuRecord("Stats", "/dev/stats"),
            new DevMenuRecord("WeaponClass", "/dev/weaponClass"),
            new DevMenuRecord("Weapon", "/dev/weapon"),
            new DevMenuRecord("Rarity", "/dev/rarity"),
            new DevMenuRecord("Element", "/dev/element"),
            new DevMenuRecord("Chest Collection", "/dev/collection"),
            new DevMenuRecord("Chest", "/dev/chest"),
            new DevMenuRecord("Material", "/dev/material"),
            new DevMenuRecord("Affiliation", "/dev/affiliation"),
            new DevMenuRecord("Class", "/dev/class"),
            new DevMenuRecord("Character", "/dev/character"),
            new DevMenuRecord("Dungeon", "/dev/dungeon"),
            new DevMenuRecord("Artefact", "/dev/artefact")


    );


    @GetMapping("/dev/menu")
    public String getMenu(Model model) {
        model.addAttribute("Nav", NAV_LINKS);
        System.out.println(model);
        return "dev/menu";
    }

    @GetMapping("/dev")
    public String getShortMenu(Model model) {
        return "redirect:/dev/menu";
    }
}
