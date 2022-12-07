package com.gachaapi.Controller.dev;


import com.gachaapi.Service.interfaces.CharacterService;
import com.gachaapi.Service.interfaces.ChestService;
import com.gachaapi.Service.interfaces.CollectionService;
import com.gachaapi.Service.interfaces.WeaponService;
import com.gachaapi.Utils.dev.NewCharacterChest;
import com.gachaapi.Utils.dev.NewChest;
import com.gachaapi.Utils.dev.NewWeaponChest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class DevChestController {

    private ChestService chestService;
    private CollectionService collectionService;
    private WeaponService weaponService;
    private CharacterService characterService;

    @GetMapping("/dev/chest")
    public String getChests(Model model){
        model.addAttribute("chestList", chestService.getAll());
        model.addAttribute("collectionList", collectionService.getAll());
        return "dev/chest";
    }

    @PostMapping("/dev/chest")
    public String createChest(Model model, @ModelAttribute("newChest")NewChest newChest){
        chestService.create(newChest);
        return "redirect:/dev/chest";
    }

    @GetMapping("/dev/chest/delete/{id}")
    public String deleteChest(Model model, @PathVariable("id")int id){
        chestService.delete(id);
        return "redirect:/dev/chest";
    }

    @GetMapping("/dev/chest/weapon/{id}")
    public String getChestWeapons(Model model, @PathVariable("id")int id){
        model.addAttribute("chest", chestService.getById(id));
        model.addAttribute("weaponList", weaponService.getAll());
        return "dev/weaponChest";
    }

    @PostMapping("/dev/chest/weapon")
    public String createChestWeapon(Model model, @ModelAttribute("newWeaponChest")NewWeaponChest newWeaponChest){
        chestService.addWeapon(newWeaponChest.getChestId(), newWeaponChest.getWeaponId());
        return "redirect:/dev/chest/weapon/"+newWeaponChest.getChestId();
    }

    @GetMapping("/dev/chest/weapon/delete/{weaponId}/{chestId}")
    public String deleteWeapon(Model model, @PathVariable("weaponId")int weaponId, @PathVariable("chestId")int chestId){
        chestService.deleteWeapon(chestId, weaponId);
        return "redirect:/dev/chest/weapon/"+chestId;
    }

    @GetMapping("/dev/chest/character/{id}")
    public String getChestCharacters(Model model, @PathVariable("id")int id){
        model.addAttribute("chest", chestService.getById(id));
        model.addAttribute("characterList", characterService.getAll());
        return "dev/characterChest";
    }

    @PostMapping("/dev/chest/character")
    public String createChestCharacter(Model model, @ModelAttribute("newCharacterChest") NewCharacterChest newCharacterChest){
        chestService.addCharacter(newCharacterChest.getChestId(), newCharacterChest.getCharacterId());
        return "redirect:/dev/chest/character/"+newCharacterChest.getChestId();
    }

    @GetMapping("/dev/chest/character/delete/{characterId}/{chestId}")
    public String deleteCharacter(Model model, @PathVariable("characterId")int characterId, @PathVariable("chestId")int chestId){
        chestService.deleteCharacter(chestId, characterId);
        return "redirect:/dev/chest/character/"+chestId;
    }

}
