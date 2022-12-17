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

import static com.gachaapi.Utils.Constants.PREMIUM_ROLE;

@Service
@AllArgsConstructor
public class PremiumServiceImpl implements PremiumService {

    private PlayerRepository playerRepository;
    private PremiumPurchaseRepository premiumPurchaseRepository;
    private RoleRepository roleRepository;

    private final static int PREMIUM_DAY_PRICE = 10;

    @Override
    public PremiumPurchase buyPremium(String nickname, int days) {
        Player player = playerRepository.findByNick(nickname).orElseThrow();
        if (days<1)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "invalid period");

        if (player.pay(days*PREMIUM_DAY_PRICE)) {

            PremiumPurchase pp = new PremiumPurchase();
            pp.setBoughtAt(Timestamp.from(Instant.now()));
            pp.setDays(days);
            pp.setPlayer(player);
            premiumPurchaseRepository.save(pp);

            int premiumLeft = player.getPremiumLeft();
            player.setPremiumLeft(premiumLeft + days);
            player.getRoles().add(roleRepository.findByName(PREMIUM_ROLE));
            playerRepository.save(player);

            return pp;
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You dont have enough money");
    }

    @Override
    public int getPremiumDaysLeft(String nickname) {
        return playerRepository.findByNick(nickname).orElseThrow().getPremiumLeft();
    }
}
