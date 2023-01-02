package com.gachaapi.Controller.dev;


import com.gachaapi.Service.interfaces.MaterialService;
import com.gachaapi.Service.interfaces.WeaponClassService;
import com.gachaapi.Utils.dev.NewMaterialWeaponClass;
import com.gachaapi.Utils.dev.NewWeaponClass;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class DevWeaponClassController {

    WeaponClassService weaponClassService;
    MaterialService materialService;

    @GetMapping("/dev/weaponClass")
    public String getWeaponClass(Model model){
        model.addAttribute("weaponClassList", weaponClassService.getAll());
        return "dev/WeaponClass";
    }

    @PostMapping("/dev/weaponClass")
    public String createWeaponClass(Model model, @ModelAttribute("newWeaponClass")NewWeaponClass newWeaponClass){
        weaponClassService.create(newWeaponClass);
        return "redirect:/dev/weaponClass";
    }

    @GetMapping("/dev/weaponClass/delete/{id}")
    public String deleteWeaponCLass(Model model, @PathVariable("id")int id){
        weaponClassService.delete(id);
        return "redirect:/dev/weaponClass";
    }

    @GetMapping("/dev/weaponClass/material/{id}")
    public String getWeaponClassMaterial(Model model, @PathVariable("id") int weaponClassId){
        model.addAttribute("weaponClass", weaponClassService.getById(weaponClassId));
        model.addAttribute("materialList", materialService.getAll());
        return "dev/WeaponClassMaterial";
    }

    @PostMapping("/dev/weaponClass/material")
    public String createWeaponClassMaterial(Model model, @ModelAttribute("newWeaponClassMaterial")NewMaterialWeaponClass newMaterialWeaponClass){
        weaponClassService.addMaterial(newMaterialWeaponClass);
        return "redirect:/dev/weaponClass/material/"+newMaterialWeaponClass.getWeaponClassId();
    }

    @GetMapping("/dev/weaponClass/material/delete/{id}/{weaponClassId}")
    public String deleteWeaponClassMaterial(Model model, @PathVariable("id")int id, @PathVariable("weaponClassId")int weaponClassId){
        weaponClassService.deleteMaterial(id);
        return "redirect:/dev/weaponClass/material/"+weaponClassId;
    }
}
