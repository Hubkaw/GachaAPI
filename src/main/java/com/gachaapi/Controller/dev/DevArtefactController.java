package com.gachaapi.Controller.dev;


import com.gachaapi.Service.interfaces.ArtefactService;
import com.gachaapi.Service.interfaces.RarityService;
import com.gachaapi.Service.interfaces.SetService;
import com.gachaapi.Service.interfaces.StatisticService;
import com.gachaapi.Utils.dev.NewArtefact;
import com.gachaapi.Utils.dev.NewArtefactSet;
import com.gachaapi.Utils.dev.NewStatArtefact;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import static com.gachaapi.Utils.Constants.CANT_DELETE_USED;

@Controller
@AllArgsConstructor
public class DevArtefactController {


    private ArtefactService artefactService;
    private RarityService rarityService;
    private StatisticService statisticService;
    private SetService setService;

    @GetMapping("/dev/artefact")
    public String getArtefact(Model model){
        model.addAttribute("artefactList", artefactService.getAll());
        model.addAttribute("rarityList", rarityService.getAll());
        return "dev/Artefact";
    }

    @PostMapping("/dev/artefact")
    public String createArtefact(Model model, @ModelAttribute("newArtefact") NewArtefact newArtefact, BindingResult result){
        if (result.hasErrors()){
            model.addAttribute("artefactList", artefactService.getAll());
            model.addAttribute("rarityList", rarityService.getAll());
            model.addAttribute("error", "Invalid Parameters");
            return "dev/Artefact";
        }
        try {
            artefactService.create(newArtefact);
            return "redirect:/dev/artefact";
        }catch (Exception e){
            model.addAttribute("artefactList", artefactService.getAll());
            model.addAttribute("rarityList", rarityService.getAll());
            model.addAttribute("error", e.getMessage());
            return "dev/Artefact";
        }
    }

    @GetMapping("/dev/artefact/delete/{id}")
    public String deleteArtefact(Model model, @PathVariable("id")int id){
        try {
            artefactService.delete(id);
            return "redirect:/dev/artefact";
        } catch (Exception e){
            model.addAttribute("artefactList", artefactService.getAll());
            model.addAttribute("rarityList", rarityService.getAll());
            model.addAttribute("error", CANT_DELETE_USED);
            return "dev/Artefact";
        }
    }
    @GetMapping("/dev/artefact/stats/{id}")
    public String getStatArtefact(Model model, @PathVariable("id")int id){
        model.addAttribute("artefact", artefactService.getById(id));
        model.addAttribute("statList", statisticService.getAll());
        return "dev/StatArtefact";
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

    @GetMapping("/dev/artefact/sets/{id}")
    public String getArtefactSets(Model model, @PathVariable("id") int id){
        model.addAttribute("artefact", artefactService.getById(id));
        model.addAttribute("setList", setService.getAll());
        return "dev/SetArtefact";
    }
    @PostMapping("/dev/artefact/sets")
    public String createArtefactSet(Model model, @ModelAttribute("newArtefactSet") NewArtefactSet newArtefactSet){
        artefactService.createArtefactSet(newArtefactSet);
        return "redirect:/dev/artefact/sets/"+newArtefactSet.getArtefactId();
    }

    @GetMapping("/dev/artefact/sets/delete/{id}/{artefactId}")
    public String deleteArtefactSet(Model model, @PathVariable("id")int id, @PathVariable("artefactId")int artefactId){
        artefactService.deleteArtefactSet(id, artefactId);
        return "redirect:/dev/artefact/sets/"+artefactId;
    }

}

