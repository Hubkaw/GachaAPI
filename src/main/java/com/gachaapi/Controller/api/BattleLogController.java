package com.gachaapi.Controller.api;

import com.gachaapi.Entity.BattleHistory;
import com.gachaapi.Service.interfaces.BattleLogsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@AllArgsConstructor
@Controller
public class BattleLogController {

    private BattleLogsService battleLogsService;

    @GetMapping("/api/history")
    public ResponseEntity<List<BattleHistory>> getAllBattleLogs(Principal principal){
        return ResponseEntity.ok(battleLogsService.getAllByPlayer(principal.getName()));
    }

    @GetMapping("/api/history/attacker")
    public ResponseEntity<List<BattleHistory>> getAllAttackerBattleLogs(Principal principal){
        return ResponseEntity.ok(battleLogsService.getAllByAttacker(principal.getName()));
    }

    @GetMapping("/api/history/defender")
    public ResponseEntity<List<BattleHistory>> getAllDefenderBattleLogs(Principal principal){
        return ResponseEntity.ok(battleLogsService.getAllByDefender(principal.getName()));
    }
}
