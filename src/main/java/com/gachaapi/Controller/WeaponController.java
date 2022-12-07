package com.gachaapi.Controller;

import com.gachaapi.Entity.Weapon;
import com.gachaapi.Service.interfaces.WeaponService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@AllArgsConstructor
@Controller
public class WeaponController {

    private WeaponService weaponService;

    @GetMapping("/weapons")
    public ResponseEntity<List<Weapon>> getWeapons(){
        return new ResponseEntity<>(weaponService.getAll(), HttpStatus.OK);
    }

}
