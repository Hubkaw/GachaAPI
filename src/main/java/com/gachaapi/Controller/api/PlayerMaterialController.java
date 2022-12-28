package com.gachaapi.Controller.api;

import com.gachaapi.Entity.PlayerMaterial;
import com.gachaapi.Service.interfaces.PlayerMaterialService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Controller
@AllArgsConstructor
public class PlayerMaterialController {

    private PlayerMaterialService playerMaterialService;


    @GetMapping("/api/player/materials")
    public ResponseEntity<List<PlayerMaterial>> getPlayerMaterials(Principal principal){
        return ResponseEntity.ok(playerMaterialService.getAll(principal.getName()));
    }
}
