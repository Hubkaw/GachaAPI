package com.gachaapi.Controller;

import com.gachaapi.Entity.Player;
import com.gachaapi.Utils.NewPlayer;
import com.gachaapi.Security.Service.JWTService;
import com.gachaapi.Service.interfaces.PlayerService;
import com.gachaapi.Utils.TokenResponse;
import lombok.AllArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;
import org.thymeleaf.spring5.view.ThymeleafView;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.text.ParseException;

import static com.gachaapi.Utils.Constants.ADMIN_ROLE;

@Controller
@AllArgsConstructor
public class SecurityController {

    private final JWTService jwtService;
    private final PlayerService playerService;

    @GetMapping("/token")
    public ResponseEntity<TokenResponse> token(Authentication authentication) {
        if (authentication == null)
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        return new ResponseEntity<>(new TokenResponse(jwtService.generateToken(authentication), "Bearer"), HttpStatus.OK);
    }

    @PostMapping("/new-account")
    public ResponseEntity<Player> createPlayer(@RequestBody NewPlayer newPlayer) {
        try {
            return new ResponseEntity<>(playerService.createNewPlayer(newPlayer), HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/signup")
    public ModelAndView getSignup(Model model) {
        return new ModelAndView("game/signup");
    }

    @PostMapping("/signup")
    public String createAccount(Model model, @ModelAttribute("newPlayer") NewPlayer newPlayer) {
        try {
            playerService.createNewPlayer(newPlayer);
        } catch (ResponseStatusException e) {
            model.addAttribute("error", e.getReason());
            return "game/signup";
        }
        return "redirect:/login";
    }

    @GetMapping("/login")
    public ModelAndView getLoginPage(Model model) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("game/login");
        return mv;
    }

    @GetMapping("/")
    public RedirectView getRedirector(Model model, Principal principal) {
        RedirectView redirectView = new RedirectView();
        if (principal == null || principal.getName() == null) {
            redirectView.setUrl("/login");
        } else if (principal.getName().equals("admin")) {
            redirectView.setUrl("/dev/menu");
        } else {
            redirectView.setUrl("/game/home");
        }
        return redirectView;
    }

}
