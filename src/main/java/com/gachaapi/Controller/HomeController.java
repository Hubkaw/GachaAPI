package com.gachaapi.Controller;

import lombok.AllArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class HomeController {

    @GetMapping("/home")
    public ModelAndView getHome(Model model){
        return new ModelAndView("game/home");
    }

}
