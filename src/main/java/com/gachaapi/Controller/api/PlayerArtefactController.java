package com.gachaapi.Controller.api;


import com.gachaapi.Entity.PlayerArtefact;
import com.gachaapi.Service.interfaces.PlayerArtefactService;
import com.gachaapi.Utils.api.ArtefactLevelUpInfo;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.security.Principal;
import java.util.List;

@Controller
@AllArgsConstructor
public class PlayerArtefactController {

    private PlayerArtefactService playerArtefactService;


    @GetMapping("/api/player/artefacts")
    public ResponseEntity<List<PlayerArtefact>> getPlayerArtefacts(Principal principal){
        return ResponseEntity.ok(playerArtefactService.getAll(principal.getName()));
    }

    @PostMapping("/api/player/artefacts/levelUp")
    public ResponseEntity<PlayerArtefact> levelUpPlayerArtefact(@RequestBody ArtefactLevelUpInfo artefactLevelUpInfo, Principal principal){
        return ResponseEntity.ok(playerArtefactService.levelUp(artefactLevelUpInfo.getUpgradedArtefactId(), artefactLevelUpInfo.getSacrificedArtefactId(), principal.getName()));
    }
}
