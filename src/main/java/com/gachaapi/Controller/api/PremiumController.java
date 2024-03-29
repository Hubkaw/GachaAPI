package com.gachaapi.Controller.api;

import com.gachaapi.Entity.PremiumPurchase;
import com.gachaapi.Service.interfaces.PlayerService;
import com.gachaapi.Service.interfaces.PremiumService;
import com.gachaapi.Utils.PremiumRewards;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;

@Controller()
@AllArgsConstructor
public class PremiumController {

    private PremiumService premiumService;
    private PlayerService playerService;

    @GetMapping("/api/premium")
    public ResponseEntity<Integer> getPremiumDaysLeft(Principal principal){
        int premiumDaysLeft = premiumService.getPremiumDaysLeft(principal.getName());
        return ResponseEntity.ok(premiumDaysLeft);
    }

    @GetMapping("/api/premium/buy/{days}")
    public ResponseEntity<PremiumPurchase> getBuyPremium(Principal principal,@PathVariable("days") int days){
        return ResponseEntity.ok(premiumService.buyPremium(principal.getName(), days));
    }

    @GetMapping("/api/premium/rewards")
    public ResponseEntity<PremiumRewards> getPremiumRewards(Principal principal){
        PremiumRewards premiumRewards = playerService.getPremiumRewards(principal.getName());
        if (premiumRewards == null){
            return new ResponseEntity<PremiumRewards>(HttpStatus.NOT_ACCEPTABLE);
        }
        return ResponseEntity.ok(premiumRewards);
    }

}
