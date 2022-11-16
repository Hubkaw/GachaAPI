package com.gachaapi.Controller;

import com.gachaapi.Service.interfaces.StatisticService;
import com.gachaapi.Utils.dev.DevMenuRecord;
import com.gachaapi.Utils.dev.NewStat;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import static java.util.Arrays.asList;

@AllArgsConstructor
@Controller()
public class DevController {

    private StatisticService statisticService;

    private static List<DevMenuRecord> NAV_LINKS = asList(
            new DevMenuRecord("Menu", "/dev/menu"),
            new DevMenuRecord("Stats", "/dev/stats")
    );


    @GetMapping("/dev/menu")
    public String getMenu(Model model) {
        model.addAttribute("Nav", NAV_LINKS);
        System.out.println(model);
        return "dev/menu";
    }

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
}
