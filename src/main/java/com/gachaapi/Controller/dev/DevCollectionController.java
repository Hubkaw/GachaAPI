package com.gachaapi.Controller.dev;

import com.gachaapi.Service.interfaces.CollectionService;
import com.gachaapi.Utils.dev.NewCollection;
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
public class DevCollectionController {

    private CollectionService collectionService;

    @GetMapping("/dev/collection")
    public String getCollections(Model model){
        model.addAttribute("collectionList", collectionService.getAll());
        return "dev/Collection";
    }

    @PostMapping("/dev/collection")
    public String createCollection(Model model, @ModelAttribute("newCollection")NewCollection newCollection){
        collectionService.create(newCollection);
        return "redirect:/dev/collection";
    }

    @GetMapping("/dev/collection/delete/{id}")
    public String deleteCollection(Model model, @PathVariable("id")int id){
        try {
            collectionService.delete(id);
            return "redirect:/dev/collection";
        } catch (Exception e){
            model.addAttribute("collectionList", collectionService.getAll());
            model.addAttribute("error", CANT_DELETE_USED);
            return "dev/Collection";
        }
    }
}
