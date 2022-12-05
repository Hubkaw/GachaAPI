package com.gachaapi.Controller.dev;


import com.gachaapi.Service.interfaces.ArtefactService;
import com.gachaapi.Service.interfaces.RarityService;
import com.gachaapi.Service.interfaces.StatisticService;
import com.gachaapi.Utils.dev.NewArtefact;
import com.gachaapi.Utils.dev.NewStatArtefact;
import com.gachaapi.Utils.dev.NewStatWeapon;
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
    private StatisticService statisticService;

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
    @GetMapping("/dev/artefact/stats/{id}")
    public String getStatArtefact(Model model, @PathVariable("id")int id){
        model.addAttribute("artefact", artefactService.getById(id));
        model.addAttribute("statList", statisticService.getAll());
        return "dev/statArtefact";
    }

    @PostMapping("/dev/artefact/stats")
    public String createStatArtefact(Model model, @ModelAttribute("newStatArtefact") NewStatArtefact newStatArtefact){
        artefactService.createStatArtefact(newStatArtefact);
        return "redirect:/dev/artefact/stats/"+newStatArtefact.getArtefactId();
    }

    @GetMapping("/dev/artefact/stats/delete/{id}/{artefactId}")
    public String deleteStatArtefact(Model model, @PathVariable("id")int id, @PathVariable("artefactId")int artefactId){
        artefactService.deleteStatArtefact(id);
        return "redirect:/dev/artefact/stats/"+artefactId;
    }
}

