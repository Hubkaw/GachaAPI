package com.gachaapi.Controller.dev;

import com.gachaapi.Service.interfaces.ElementService;
import com.gachaapi.Service.interfaces.MaterialService;
import com.gachaapi.Utils.dev.NewElement;
import com.gachaapi.Utils.dev.NewMaterialElement;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import static com.gachaapi.Utils.Constants.CANT_DELETE_USED;

@AllArgsConstructor
@Controller
public class DevElementController {

    private ElementService elementService;
    private MaterialService materialService;

    @GetMapping("/dev/element")
    public String getElements(Model model){
        model.addAttribute("elementList", elementService.getAll());
        return "dev/Element";
    }

    @PostMapping("/dev/element")
    public String createElement(Model model, @ModelAttribute("newElement")NewElement newElement){
        elementService.create(newElement);
        return "redirect:/dev/element";
    }

    @GetMapping("/dev/element/delete/{id}")
    public String deleteElement(Model model, @PathVariable("id")int id){
        try {
            elementService.delete(id);
            return "redirect:/dev/element";
        } catch (Exception e){
            model.addAttribute("elementList", elementService.getAll());
            model.addAttribute("error", CANT_DELETE_USED);
            return "dev/Element";
        }
    }

    @GetMapping("/dev/element/material/{id}")
    public String getElementMaterial(Model model, @PathVariable("id")int elementId){
        model.addAttribute("element", elementService.getById(elementId));
        model.addAttribute("materialList", materialService.getAll());
        return "dev/ElementMaterial";
    }

    @PostMapping("/dev/element/material")
    public String createElementMaterial(Model model, @ModelAttribute("newMaterialElement")NewMaterialElement newMaterialElement){
        elementService.addMaterial(newMaterialElement);
        return "redirect:/dev/element/material/"+newMaterialElement.getElementId();
    }

    @GetMapping("/dev/element/material/delete/{materialElementId}/{elementId}")
    public String deleteElementMaterial(Model model, @PathVariable("materialElementId")int materialElementId, @PathVariable("elementId")int elementId){
        elementService.deleteMaterial(materialElementId);
        return "redirect:/dev/element/material/"+elementId;
    }
}
