package com.gachaapi.Controller.dev;

import com.gachaapi.Repository.PlayerCharacterRepository;
import com.gachaapi.Service.interfaces.AdminCharacterService;
import com.gachaapi.Service.interfaces.ArtefactService;
import com.gachaapi.Service.interfaces.CharacterService;
import com.gachaapi.Service.interfaces.WeaponService;
import com.gachaapi.Utils.ArtefactType;
import com.gachaapi.Utils.dev.NewAdminCharacter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class DevAdminCharacterController {

    private CharacterService characterService;
    private WeaponService weaponService;
    private ArtefactService artefactService;
    private AdminCharacterService adminCharacterService;

    @GetMapping("/dev/admin/character")
    public String getAdminCharacter(Model model){
        model.addAttribute("characterList", characterService.getAll());
        model.addAttribute("weaponList", weaponService.getAll());
        model.addAttribute("ringList", artefactService.getAllByType(ArtefactType.RING));
        model.addAttribute("glassesList", artefactService.getAllByType(ArtefactType.GLASSES));
        model.addAttribute("hatList", artefactService.getAllByType(ArtefactType.HAT));
        model.addAttribute("adminCharacterList", adminCharacterService.getAll());
        return "dev/adminCharacter";
    }

    @PostMapping("/dev/admin/character")
    public String createAdminCharacter(Model model, @ModelAttribute("newAdminCharacter")NewAdminCharacter newAdminCharacter){
        adminCharacterService.create(newAdminCharacter);
        return "redirect:/dev/admin/character";
    }

    @GetMapping("/dev/admin/character/delete/{id}")
    public String deleteAdminCharacter(Model model, @PathVariable("id")int id){
        adminCharacterService.delete(id);
        return "redirect:/dev/admin/character";
    }

}
