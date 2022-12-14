package com.gachaapi.Controller.dev;

import com.gachaapi.Service.interfaces.AdminCharacterService;
import com.gachaapi.Service.interfaces.DungeonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.Column;

@Controller
@AllArgsConstructor
public class DevAdminPartyController {

    private DungeonService dungeonService;
    private AdminCharacterService adminCharacterService;

    @GetMapping("/dev/admin/party")
    public String getAdminParty(Model model){
        model.addAttribute("dungeonList", dungeonService.getAll());
        model.addAttribute("characterList", adminCharacterService.getAll());
        return "dev/adminParty";
    }
}
