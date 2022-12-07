package com.gachaapi.Controller;

import com.gachaapi.Entity.Artefact;
import com.gachaapi.Service.interfaces.ArtefactService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@AllArgsConstructor
@Controller
public class ArtefactController {

    private ArtefactService artefactService;


    @GetMapping("/artefacts")
    public ResponseEntity<List<Artefact>> getArtefacts(){
        return new ResponseEntity<>(artefactService.getAll(), HttpStatus.OK);
    }
}
