package com.gachaapi.Controller.dev;


import com.gachaapi.Service.interfaces.MaterialService;
import com.gachaapi.Utils.dev.NewMaterial;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@AllArgsConstructor
@Controller
public class DevMaterialController {

    private MaterialService materialService;

    @GetMapping("/dev/material")
    public String getMaterial(Model model){
        model.addAttribute("materialList", materialService.getAll());
        return "dev/Material";
    }

    @PostMapping("/dev/material")
    public String createMaterial(Model model, @ModelAttribute("newMaterial")NewMaterial newMaterial){
        materialService.create(newMaterial);
        return "redirect:/dev/material";
    }

    @GetMapping("/dev/material/delete/{id}")
    public String deleteMaterial(Model model, @PathVariable("id")int id){
        materialService.delete(id);
        return "redirect:/dev/material";
    }
}
