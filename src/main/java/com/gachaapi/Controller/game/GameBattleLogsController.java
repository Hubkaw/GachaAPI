package com.gachaapi.Controller.game;

import com.gachaapi.Service.interfaces.BattleLogsService;
import com.gachaapi.Service.interfaces.PVPService;
import com.gachaapi.Service.interfaces.PlayerService;
import com.gachaapi.Utils.BattleType;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@AllArgsConstructor


public class GameBattleLogsController {

    //how to get enemies
    private PlayerService playerService;

    private BattleLogsService battleLogsService;



    /*
    @GetMapping("/reports/{reportId}")
    public String getPvPSelection(Model model, Principal principal, @PathVariable Integer reportId){
        model.addAttribute("player", playerService.getByName(principal.getName()));
        model.addAttribute("reports", battleLogsService.findAllByTypeAndNick(principal.getName(),1, PageRequest.of(0,50)));
        return "game/pvp_selection";
    }
*/
    @GetMapping("/game/reports")
    public ModelAndView getAttackingReports(Model model, Principal principal){
        return new ModelAndView("game/battleLogsList")
                .addObject("attRep",battleLogsService.getAllByAttacker(principal.getName()))
                .addObject("defRep",battleLogsService.getAllByDefender(principal.getName()))
                .addObject("player",playerService.getByName(principal.getName()));


    }

}


//dopisz service,do model and view dodaj  addobject, chestlist po przecinku [wybranyservice].getall()
// z dev lista, w images dodaj foldery na klasy nazwy zdjec jako IDki