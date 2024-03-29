package com.gachaapi.Controller.dev;


import com.gachaapi.Service.interfaces.AffiliationService;
import com.gachaapi.Service.interfaces.MaterialService;
import com.gachaapi.Service.interfaces.StatisticService;
import com.gachaapi.Utils.dev.NewAffiliation;
import com.gachaapi.Utils.dev.NewAffiliationStat;
import com.gachaapi.Utils.dev.NewMaterialAffiliation;
import lombok.AllArgsConstructor;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import static com.gachaapi.Utils.Constants.CANT_DELETE_USED;

@AllArgsConstructor
@Controller
public class DevAffiliationController {

    private AffiliationService affiliationService;
    private StatisticService statisticService;
    private MaterialService materialService;

    @GetMapping("/dev/affiliation")
    public String getAffiliation(Model model){
        model.addAttribute("affiliationList", affiliationService.getAll());
        return "dev/Affiliation";
    }

    @PostMapping("/dev/affiliation")
    public String createAffiliation(Model model, @ModelAttribute("newAffiliation")NewAffiliation newAffiliation){
        affiliationService.create(newAffiliation);
        return "redirect:/dev/affiliation";
    }

    @GetMapping("/dev/affiliation/delete/{id}")
    public String deleteAffiliation(Model model, @PathVariable("id") int id){
        try {
            affiliationService.delete(id);
            return "redirect:/dev/affiliation";
        } catch (Exception e){
            model.addAttribute("affiliationList", affiliationService.getAll());
            model.addAttribute("error", CANT_DELETE_USED);
            return "dev/Affiliation";
        }
    }

    @GetMapping("/dev/affiliation/stats/{id}")
    public String getAffiliationStats(Model model, @PathVariable("id")int id){
        model.addAttribute("affiliation", affiliationService.getById(id));
        model.addAttribute("statList", statisticService.getAll());
        return "dev/StatAffiliation";
    }

    @PostMapping("/dev/affiliation/stats")
    public String createAffiliationStats(Model model, @ModelAttribute("newAffiliationStat")NewAffiliationStat newAffiliationStat){
        affiliationService.addStat(newAffiliationStat);
        return "redirect:/dev/affiliation/stats/"+newAffiliationStat.getAffiliationId();
    }

    @GetMapping("/dev/affiliation/stats/delete/{id}/{affiliationId}")
    public String deleteAffiliationStats(Model model, @PathVariable("id")int id, @PathVariable("affiliationId") int affiliationId){
        try {
            affiliationService.deleteStat(id);
            return "redirect:/dev/affiliation/stats/" + affiliationId;
        } catch (ConstraintViolationException e){
            model.addAttribute("affiliation", affiliationService.getById(affiliationId));
            model.addAttribute("statList", statisticService.getAll());
            model.addAttribute("error", CANT_DELETE_USED);
            return "dev/StatAffiliation";
        }

    }

    @GetMapping("/dev/affiliation/material/{id}")
    public String getAffilationMaterials(Model model, @PathVariable("id")int id){
        model.addAttribute("affiliation", affiliationService.getById(id));
        model.addAttribute("materialList", materialService.getAll());
        return "dev/MaterialAffiliation";
    }

    @PostMapping("/dev/affiliation/material")
    public String createAffiliationMaterial(Model model, @ModelAttribute("newMaterialAffiliation")NewMaterialAffiliation newMaterialAffiliation){
        affiliationService.addMaterial(newMaterialAffiliation);
        return "redirect:/dev/affiliation/material/"+newMaterialAffiliation.getAffiliationId();
    }

    @GetMapping("/dev/affiliation/material/delete/{id}/{affiliationId}")
    public String deleteAffiliationMaterial(Model model, @PathVariable("id") int id, @PathVariable("affiliationId") int affiliationId){
        affiliationService.deleteMaterial(id);
        return "redirect:/dev/affiliation/material/"+affiliationId;
    }

}
