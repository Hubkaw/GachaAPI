package com.gachaapi.Controller.dev;


import com.gachaapi.Service.interfaces.*;
import com.gachaapi.Utils.dev.NewStatWeapon;
import com.gachaapi.Utils.dev.NewWeapon;
import lombok.AllArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@AllArgsConstructor
@Controller
public class WeaponController {
    private WeaponService weaponService;
    private RarityService rarityService;
    private WeaponClassService weaponClassService;
    private ElementService elementService;
    private StatisticService statisticService;

    @GetMapping("/dev/weapon")
    private String getWeapon(Model model){
        model.addAttribute("weaponList", weaponService.getAll());
        model.addAttribute("elementList", elementService.getAll());
        model.addAttribute("weaponClassList",weaponClassService.getAll());
        model.addAttribute("rarityList", rarityService.getAll());
        return "dev/weapon";
    }

    @PostMapping("/dev/weapon")
    private String createWeapon(Model model, @ModelAttribute("newWeapon")NewWeapon newWeapon){
        weaponService.create(newWeapon);
        return "redirect:/dev/weapon";
    }

    @GetMapping("/dev/weapon/delete/{id}")
    private String deleteWeapon(Model model, @PathVariable("id")int id){
        weaponService.delete(id);
        return "redirect:/dev/weapon";
    }

    @GetMapping("/dev/weapon/stats/{id}")
    public String getStatWeapon(Model model, @PathVariable("id")int id){
        model.addAttribute("weapon", weaponService.getById(id));
        model.addAttribute("statList", statisticService.getAll());
        return "dev/statWeapon";
    }

    @PostMapping("/dev/weapon/stats")
    public String createStatWeapon(Model model, @ModelAttribute("newStatWeapon")NewStatWeapon newStatWeapon){
        weaponService.createStatWeapon(newStatWeapon);
        return "redirect:/dev/weapon/stats/"+newStatWeapon.getWeaponId();
    }

    @GetMapping("dev/weapon/stats/delete/{id}/{weaponId}")
    public String deleteStatWeapon(Model model, @PathVariable("id")int id, @PathVariable("weaponId")int weaponId){
        weaponService.deleteStatWeapon(id);
        return "redirect:/dev/weapon/stats/"+weaponId;
    }
}
