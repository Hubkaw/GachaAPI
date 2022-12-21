package com.gachaapi.Controller.api;

import com.gachaapi.Entity.Material;
import com.gachaapi.Service.interfaces.MaterialService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@AllArgsConstructor
@Controller
public class MaterialController {

    private MaterialService materialService;

    @GetMapping("/api/materials")
    public ResponseEntity<List<Material>> getMaterials(){
        return new ResponseEntity<>(materialService.getAll(), HttpStatus.OK);
    }

}
