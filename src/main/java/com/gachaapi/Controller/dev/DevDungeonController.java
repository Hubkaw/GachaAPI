package com.gachaapi.Controller.dev;

import com.gachaapi.Service.interfaces.DungeonService;
import com.gachaapi.Utils.dev.NewCollection;
import com.gachaapi.Utils.dev.NewDungeon;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import static com.gachaapi.Utils.Constants.CANT_DELETE_USED;

@Controller
@AllArgsConstructor
public class DevDungeonController {

    private DungeonService dungeonService;


    @GetMapping("/dev/dungeon")
    public String getDungeons(Model model){
        model.addAttribute("dungeonList", dungeonService.getAll());
        return "dev/Dungeon";
    }

    @PostMapping("/dev/dungeon")
    public String createDungeons(Model model, @ModelAttribute("newDungeon") NewDungeon newDungeon){
        dungeonService.create(newDungeon);
        return "redirect:/dev/dungeon";
    }

    @GetMapping("/dev/dungeon/delete/{id}")
    public String deleteDungeon(Model model, @PathVariable("id")int id){
        try {
            dungeonService.delete(id);
            return "redirect:/dev/dungeon";
        } catch (Exception e){
            model.addAttribute("dungeonList", dungeonService.getAll());
            model.addAttribute("error", CANT_DELETE_USED);
            return "dev/Dungeon";
        }
    }
}
