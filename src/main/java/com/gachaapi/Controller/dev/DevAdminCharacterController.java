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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;

import static com.gachaapi.Utils.Constants.CANT_DELETE_USED;

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
        return "dev/AdminCharacter";
    }

    @PostMapping("/dev/admin/character")
    public String createAdminCharacter(Model model, @ModelAttribute("newAdminCharacter")NewAdminCharacter newAdminCharacter, BindingResult result){
        if (result.hasErrors()){
            model.addAttribute("characterList", characterService.getAll());
            model.addAttribute("weaponList", weaponService.getAll());
            model.addAttribute("error", "Invalid parameters");
            model.addAttribute("ringList", artefactService.getAllByType(ArtefactType.RING));
            model.addAttribute("glassesList", artefactService.getAllByType(ArtefactType.GLASSES));
            model.addAttribute("hatList", artefactService.getAllByType(ArtefactType.HAT));
            model.addAttribute("adminCharacterList", adminCharacterService.getAll());
            return "dev/AdminCharacter";
        }
        try {
            adminCharacterService.create(newAdminCharacter);
            return "redirect:/dev/admin/character";
        } catch (ResponseStatusException e){
            model.addAttribute("characterList", characterService.getAll());
            model.addAttribute("weaponList", weaponService.getAll());
            model.addAttribute("error", e.getReason());
            model.addAttribute("ringList", artefactService.getAllByType(ArtefactType.RING));
            model.addAttribute("glassesList", artefactService.getAllByType(ArtefactType.GLASSES));
            model.addAttribute("hatList", artefactService.getAllByType(ArtefactType.HAT));
            model.addAttribute("adminCharacterList", adminCharacterService.getAll());
            return "dev/AdminCharacter";
        }
    }

    @GetMapping("/dev/admin/character/delete/{id}")
    public String deleteAdminCharacter(Model model, @PathVariable("id")int id){
        try {
            adminCharacterService.delete(id);
            return "redirect:/dev/admin/character";
        } catch (Exception e){
            model.addAttribute("characterList", characterService.getAll());
            model.addAttribute("weaponList", weaponService.getAll());
            model.addAttribute("error", CANT_DELETE_USED);
            model.addAttribute("ringList", artefactService.getAllByType(ArtefactType.RING));
            model.addAttribute("glassesList", artefactService.getAllByType(ArtefactType.GLASSES));
            model.addAttribute("hatList", artefactService.getAllByType(ArtefactType.HAT));
            model.addAttribute("adminCharacterList", adminCharacterService.getAll());
            return "dev/AdminCharacter";
        }
    }

}
