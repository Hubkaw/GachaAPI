package com.gachaapi.Controller.game;

import com.gachaapi.Service.interfaces.PaymentService;
import com.gachaapi.Service.interfaces.PlayerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;

@Controller
@AllArgsConstructor
public class GamePaymentController {

    private PaymentService paymentService;
    private PlayerService playerService;

    @GetMapping("/game/payment")
    public String getPayments(Model model, Principal principal){
        model.addAttribute("prices", paymentService.getAll());
        model.addAttribute("player", playerService.getByName(principal.getName()));
        return "game/payment";
    }

    @GetMapping("/game/payment/{id}")
    public String getGamePayment(Model model, Principal principal, @PathVariable int id){
        model.addAttribute("player", playerService.getByName(principal.getName()));
        model.addAttribute("price", paymentService.getById(id));
        return "game/payment_details";
    }
}
