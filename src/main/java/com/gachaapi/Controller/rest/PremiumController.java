package com.gachaapi.Controller.rest;

import com.gachaapi.Entity.PremiumPurchase;
import com.gachaapi.Service.interfaces.PremiumService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;

@Controller
@AllArgsConstructor
public class PremiumController {

    private PremiumService premiumService;

    @GetMapping("/premium")
    public ResponseEntity<Integer> getPremiumDaysLeft(Principal principal){
        int premiumDaysLeft = premiumService.getPremiumDaysLeft(principal.getName());
        return ResponseEntity.ok(premiumDaysLeft);
    }

    @GetMapping("/premium/buy/{days}")
    public ResponseEntity<PremiumPurchase> getBuyPremium(Principal principal,@PathVariable("days") int days){
        return ResponseEntity.ok(premiumService.buyPremium(principal.getName(), days));
    }

}
