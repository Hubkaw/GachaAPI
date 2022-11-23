package com.gachaapi.Controller.dev;


import com.gachaapi.Service.interfaces.AffiliationService;
import com.gachaapi.Service.interfaces.StatisticService;
import com.gachaapi.Utils.dev.NewAffiliation;
import com.gachaapi.Utils.dev.NewAffiliationStat;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@AllArgsConstructor
@Controller
public class DevAffiliationController {

    private AffiliationService affiliationService;
    private StatisticService statisticService;

    @GetMapping("/dev/affiliation")
    public String getAffiliation(Model model){
        model.addAttribute("affiliationList", affiliationService.getAll());
        return "dev/affiliation";
    }

    @PostMapping("/dev/affiliation")
    public String createAffiliation(Model model, @ModelAttribute("newAffiliation")NewAffiliation newAffiliation){
        affiliationService.create(newAffiliation);
        return "redirect:/dev/affiliation";
    }

    @GetMapping("/dev/affiliation/delete/{id}")
    public String deleteAffiliation(Model model, @PathVariable("id") int id){
        affiliationService.delete(id);
        return "redirect:/dev/affiliation";
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
        affiliationService.deleteStat(id);
        return "redirect:/dev/affiliation/stats/"+affiliationId;
    }
}
