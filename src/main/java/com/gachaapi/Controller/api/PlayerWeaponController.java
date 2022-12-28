package com.gachaapi.Controller.api;

import com.gachaapi.Entity.PlayerWeapon;
import com.gachaapi.Service.interfaces.PlayerWeaponService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;
import java.util.List;

@Controller
@AllArgsConstructor
public class PlayerWeaponController {

    private PlayerWeaponService playerWeaponService;

    @GetMapping("/api/player/weapons")
    private ResponseEntity<List<PlayerWeapon>> getPlayerWeapons(Principal principal){
        return ResponseEntity.ok(playerWeaponService.getAll(principal.getName()));
    }

    @GetMapping("/api/player/weapons/levelUp/{id}")
    private ResponseEntity<PlayerWeapon> levelUpPlayerWeapon(@PathVariable("id")int id, Principal principal){
        return ResponseEntity.ok(playerWeaponService.levelUp(id, principal.getName()));
    }


}
