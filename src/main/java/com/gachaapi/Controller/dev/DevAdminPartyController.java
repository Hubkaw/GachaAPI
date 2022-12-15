package com.gachaapi.Controller.dev;

import com.gachaapi.Repository.WeaponRepository;
import com.gachaapi.Service.interfaces.*;
import com.gachaapi.Utils.dev.NewAdminParty;
import com.gachaapi.Utils.dev.NewArtefactReward;
import com.gachaapi.Utils.dev.NewMaterialReward;
import com.gachaapi.Utils.dev.NewWeaponReward;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.persistence.Column;

@Controller
@AllArgsConstructor
public class DevAdminPartyController {

    private DungeonService dungeonService;
    private AdminCharacterService adminCharacterService;
    private AdminPartyService adminPartyService;
    private WeaponService weaponService;
    private MaterialService materialService;
    private ArtefactService artefactService;

    @GetMapping("/dev/admin/party")
    public String getAdminParty(Model model){
        model.addAttribute("dungeonList", dungeonService.getAll());
        model.addAttribute("characterList", adminCharacterService.getAll());
        model.addAttribute("partyList", adminCharacterService.getAll());
        model.addAttribute("dungeonFloorList", adminPartyService.getAllDungeonFloors());
        return "dev/adminParty";
    }

    @PostMapping("/dev/admin/party")
    public RedirectView createAdminParty(Model model, @ModelAttribute("newAdminParty") NewAdminParty newAdminParty){
        RedirectView rv = new RedirectView("/dev/admin/party");
        try {
            adminPartyService.create(newAdminParty);
        } catch (Exception e){
            rv.addStaticAttribute("error", e.getMessage());
        }
        return rv;
    }

    @GetMapping("/dev/admin/party/delete/{id}")
    public String deleteAdminParty(Model model, @PathVariable("id")int id){
        adminPartyService.delete(id);
        return "redirect:/dev/admin/party";
    }

    @GetMapping("/dev/admin/party/rewards/{id}")
    public String getAdminPartyRewards(Model model, @PathVariable("id")int id){
        model.addAttribute("dungeonFloor", adminPartyService.getDungeonFloorById(id));
        model.addAttribute("weaponList", weaponService.getAll());
        model.addAttribute("artefactList", artefactService.getAll());
        model.addAttribute("materialList", materialService.getAll());
        return "dev/rewards";
    }

    @PostMapping("/dev/admin/party/rewards/artefact")
    public String createArtefactReward(Model model, @ModelAttribute("newArtefactReward")NewArtefactReward newArtefactReward){
        adminPartyService.createArtefactReward(newArtefactReward);
        return "redirect:/dev/admin/party/rewards/"+newArtefactReward.getDungeonFloorId();
    }

    @PostMapping("/dev/admin/party/rewards/weapon")
    public String createWeaponReward(Model model, @ModelAttribute("newWeaponReward") NewWeaponReward newWeaponReward){
        adminPartyService.createWeaponReward(newWeaponReward);
        return "redirect:/dev/admin/party/rewards/"+newWeaponReward.getDungeonFloorId();
    }

    @PostMapping("/dev/admin/party/rewards/material")
    public String createMaterialReward(Model model, @ModelAttribute("newMaterialReward") NewMaterialReward newMaterialReward){
        adminPartyService.createMaterialReward(newMaterialReward);
        return "redirect:/dev/admin/party/rewards/"+newMaterialReward.getDungeonFloorId();
    }

    @GetMapping("/dev/admin/party/rewards/artefact/delete/{id}/{dfId}")
    public String deleteArtefactReward(Model model, @PathVariable("id")int id, @PathVariable("dfId")int dfId){
        adminPartyService.deleteArtefactReward(id);
        return "redirect:/dev/admin/party/rewards/"+dfId;
    }

    @GetMapping("/dev/admin/party/rewards/weapon/delete/{id}/{dfId}")
    public String deleteWeaponReward(Model model, @PathVariable("id")int id, @PathVariable("dfId")int dfId){
        adminPartyService.deleteWeaponReward(id);
        return "redirect:/dev/admin/party/rewards/"+dfId;
    }

    @GetMapping("/dev/admin/party/rewards/material/delete/{id}/{dfId}")
    public String deleteMaterialReward(Model model, @PathVariable("id")int id, @PathVariable("dfId")int dfId){
        adminPartyService.deleteMaterialReward(id);
        return "redirect:/dev/admin/party/rewards/"+dfId;
    }



}
