package com.gachaapi.Controller.dev;


import com.gachaapi.Service.interfaces.WeaponClassService;
import com.gachaapi.Utils.dev.NewWeaponClass;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class WeaponClassController {

    WeaponClassService weaponClassService;

    @GetMapping("/dev/weaponClass")
    public String getWeaponClass(Model model){
        model.addAttribute("weaponClassList", weaponClassService.getAll());
        return "dev/weaponClass";
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
}
