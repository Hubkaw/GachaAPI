package com.gachaapi.Controller.dev;

import com.gachaapi.Service.interfaces.ClassService;
import com.gachaapi.Service.interfaces.MaterialService;
import com.gachaapi.Service.interfaces.StatisticService;
import com.gachaapi.Service.interfaces.WeaponClassService;
import com.gachaapi.Utils.dev.NewClass;
import com.gachaapi.Utils.dev.NewMaterialClass;
import com.gachaapi.Utils.dev.NewStatClass;
import lombok.AllArgsConstructor;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.SQLGrammarException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import static com.gachaapi.Utils.Constants.CANT_DELETE_USED;

@Controller
@AllArgsConstructor
public class DevClassController {

    private ClassService classService;
    private WeaponClassService weaponClassService;
    private StatisticService statisticService;
    private MaterialService materialService;

    @GetMapping("/dev/class")
    public String getClasses(Model model){
        model.addAttribute("classList", classService.getAll());
        model.addAttribute("weaponClassList", weaponClassService.getAll());
        return "dev/Class";
    }

    @PostMapping("/dev/class")
    public String createClass(Model model, @ModelAttribute("newClass")NewClass newClass, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("classList", classService.getAll());
            model.addAttribute("weaponClassList", weaponClassService.getAll());
            model.addAttribute("error", "Invalid Parameters");
            return "dev/Class";
        }
        try {
            classService.create(newClass);
            return "redirect:/dev/class";
        } catch (Exception e) {
            model.addAttribute("classList", classService.getAll());
            model.addAttribute("weaponClassList", weaponClassService.getAll());
            model.addAttribute("error", "Invalid Parameters");
            return "dev/Class";
        }
    }

    @GetMapping("/dev/class/delete/{id}")
    public String deleteClass(Model model, @PathVariable("id")int id){
        try {
            classService.delete(id);
            return "redirect:/dev/class";
        } catch (Exception e){
            model.addAttribute("classList", classService.getAll());
            model.addAttribute("weaponClassList", weaponClassService.getAll());
            model.addAttribute("error", CANT_DELETE_USED);
            return "dev/Class";
        }
    }

    @GetMapping("/dev/class/stats/{id}")
    public String getClassStats(Model model, @PathVariable("id")int id){
        model.addAttribute("class", classService.getById(id));
        model.addAttribute("statList", statisticService.getAll());
        return "dev/StatClass";
    }

    @PostMapping("/dev/class/stats")
    public String createClassStats(Model model, @ModelAttribute("newStatClass")NewStatClass newStatClass){
        classService.createStatClass(newStatClass);
        return "redirect:/dev/class/stats/"+newStatClass.getClassId();
    }

    @GetMapping("/dev/class/stats/delete/{id}/{classId}")
    public String deleteClassStat(Model model, @PathVariable("id")int id, @PathVariable("classId")int classId){
        classService.deleteStatClass(id);
        return "redirect:/dev/class/stats/"+classId;
    }

    @GetMapping("/dev/class/materials/{id}")
    public String getClassMaterial(Model model, @PathVariable("id")int id){
        model.addAttribute("class", classService.getById(id));
        model.addAttribute("materialList", materialService.getAll());
        return "dev/MaterialClass";
    }

    @PostMapping("/dev/class/materials")
    public String createClassMaterial(Model model, @ModelAttribute("newMaterialClass") NewMaterialClass newMaterialClass){
        classService.createMaterialClass(newMaterialClass);
        return "redirect:/dev/class/materials/"+newMaterialClass.getClassId();
    }

    @GetMapping("/dev/class/materials/delete/{id}/{classId}")
    public String deleteClassMaterial(Model model, @PathVariable("id")int id, @PathVariable("classId")int classId){
        classService.deleteMaterialClass(id);
        return "redirect:/dev/class/materials/"+classId;
    }
}
