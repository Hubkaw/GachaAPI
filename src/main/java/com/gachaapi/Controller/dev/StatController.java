package com.gachaapi.Controller.dev;

import com.gachaapi.Service.interfaces.StatisticService;
import com.gachaapi.Utils.dev.NewStat;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@AllArgsConstructor
@Controller
public class StatController {

    private StatisticService statisticService;


    @GetMapping("/dev/stats")
    public String getStat(Model model) {
        model.addAttribute("statsList", statisticService.getAll());
        return "dev/stats";
    }

    @PostMapping("/dev/stats")
    public String postStat(Model model, @ModelAttribute("newStat")NewStat newStat){
        statisticService.addStat(newStat);
        return "redirect:/dev/stats";
    }

    @GetMapping("/dev/stats/delete/{id}")
    public String deleteStat(Model model, @PathVariable("id")int id){
        statisticService.delete(id);
        return "redirect:/dev/stats";
    }
}
