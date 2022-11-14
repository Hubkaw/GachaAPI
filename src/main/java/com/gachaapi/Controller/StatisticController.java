package com.gachaapi.Controller;

import com.gachaapi.Entity.Statistic;
import com.gachaapi.Service.interfaces.StatisticService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class StatisticController {

    private StatisticService statisticService;

    @GetMapping("/stats")
    public List<Statistic> getStats(){
        return statisticService.getAll();
    }

}
