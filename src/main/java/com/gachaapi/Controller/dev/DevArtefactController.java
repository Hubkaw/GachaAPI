package com.gachaapi.Controller.dev;


import com.gachaapi.Service.interfaces.ArtefactService;
import com.gachaapi.Service.interfaces.RarityService;
import com.gachaapi.Utils.dev.NewArtefact;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class DevArtefactController {


    private ArtefactService artefactService;
    private RarityService rarityService;

    @GetMapping("/dev/artefact")
    public String getArtefact(Model model){
        model.addAttribute("artefactList", artefactService.getAll());
        model.addAttribute("rarityList", rarityService.getAll());
        return "dev/artefact";
    }

    @PostMapping("/dev/artefact")
    public String createArtefact(Model model, @ModelAttribute("newArtefact") NewArtefact newArtefact){
        artefactService.create(newArtefact);
        return "redirect:/dev/artefact";
    }

    @GetMapping("/dev/artefact/delete/{id}")
    public String deleteArtefact(Model model, @PathVariable("id")int id){
        artefactService.delete(id);
        return "redirect:/dev/artefact";
    }
}

