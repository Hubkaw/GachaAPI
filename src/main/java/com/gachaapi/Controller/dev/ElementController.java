package com.gachaapi.Controller.dev;

import com.gachaapi.Service.interfaces.ElementService;
import com.gachaapi.Utils.dev.NewElement;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@AllArgsConstructor
@Controller
public class ElementController {

    private ElementService elementService;

    @GetMapping("/dev/element")
    public String getElements(Model model){
        model.addAttribute("elementList", elementService.getAll());
        return "dev/element";
    }

    @PostMapping("/dev/element")
    public String createElement(Model model, @ModelAttribute("newElement")NewElement newElement){
        elementService.create(newElement);
        return "redirect:/dev/element";
    }

    @GetMapping("/dev/element/delete/{id}")
    public String deleteElement(Model model, @PathVariable("id")int id){
        elementService.delete(id);
        return "redirect:/dev/element";
    }
}
