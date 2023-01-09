package com.gachaapi.Service.impl;

import com.gachaapi.Entity.Player;
import com.gachaapi.Entity.PremiumPurchase;
import com.gachaapi.Repository.PlayerRepository;
import com.gachaapi.Repository.PremiumPurchaseRepository;
import com.gachaapi.Repository.RoleRepository;
import com.gachaapi.Service.interfaces.PremiumService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
import java.time.Instant;

import static com.gachaapi.Utils.Constants.PREMIUM_DAY_PRICE;
import static com.gachaapi.Utils.Constants.PREMIUM_ROLE;

@Service
@AllArgsConstructor
public class PremiumServiceImpl implements PremiumService {

    private PlayerRepository playerRepository;
    private PremiumPurchaseRepository premiumPurchaseRepository;
    private RoleRepository roleRepository;


    @Override
    public PremiumPurchase buyPremium(String nickname, int days) {
        Player player = playerRepository.findByNick(nickname).orElseThrow();
        if (days < 1)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "invalid period");

        if (player.getPlayerBalance() < days * PREMIUM_DAY_PRICE) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You dont have enough money");
        }

        player.setPlayerBalance(player.getPlayerBalance() - (days * PREMIUM_DAY_PRICE));
        player.setPremiumLeft(player.getPremiumLeft() + days);
        if (player.getRoles().stream().noneMatch(r -> r.getName().equals(PREMIUM_ROLE))) {
            player.getRoles().add(roleRepository.findByName(PREMIUM_ROLE));
        }

        PremiumPurchase pp = new PremiumPurchase();
        pp.setPlayer(player);
        pp.setBoughtAt(Timestamp.from(Instant.now()));
        pp.setDays(days);
        premiumPurchaseRepository.save(pp);

        return pp;
    }

    @Override
    public int getPremiumDaysLeft(String nickname) {
        return playerRepository.findByNick(nickname).orElseThrow().getPremiumLeft();
    }
}
