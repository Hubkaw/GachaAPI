package com.gachaapi.Controller.dev;


import com.gachaapi.Service.interfaces.SetService;
import com.gachaapi.Service.interfaces.StatisticService;
import com.gachaapi.Utils.dev.NewSet;
import com.gachaapi.Utils.dev.NewSetStat;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class DevSetController {

    private SetService setService;
    private StatisticService statisticService;


    @GetMapping("/dev/set")
    public String getSets(Model model){
        model.addAttribute("setList", setService.getAll());
        return "dev/set";
    }

    @PostMapping("/dev/set")
    public String createSet(Model model, @ModelAttribute("newSet")NewSet newSet){
        setService.create(newSet);
        return "redirect:/dev/set";
    }

    @GetMapping("/dev/set/delete/{id}")
    public String deleteSet(Model model, @PathVariable("id")int id){
        setService.delete(id);
        return "redirect:/dev/set";
    }

    @GetMapping("/dev/set/stats/{id}")
    public String getSetStats(Model model, @PathVariable("id")int id){
        model.addAttribute("set", setService.getById(id));
        model.addAttribute("statList", statisticService.getAll());
        return "dev/setStats";
    }

    @PostMapping("/dev/set/stats")
    public String createSetStats(Model model, @ModelAttribute("newSetStat")NewSetStat newSetStat){
        setService.createSetStat(newSetStat);
        return "redirect:/dev/set/stats/"+newSetStat.getSetId();
    }

    @GetMapping("/dev/set/stats/delete/{id}/{setId}")
    public String deleteSetStats(Model model, @PathVariable("id")int id, @PathVariable("setId")int setId){
        setService.deleteSetStat(id);
        return "redirect:/dev/set/stats/"+setId;
    }
}
