package com.gachaapi;

import com.gachaapi.Entity.Player;
import com.gachaapi.Entity.Role;
import com.gachaapi.Repository.PlayerRepository;
import com.gachaapi.Repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.gachaapi.Utils.Constants.DEFAULT_STAMINA_AMOUNT;
import static com.gachaapi.Utils.Constants.PREMIUM_ROLE;

@EnableScheduling
@Component
@AllArgsConstructor
public class ScheduledTasks {

    private PlayerRepository playerRepository;
    private RoleRepository roleRepository;

    @Bean
    @Scheduled(cron = "0 0 3 * * *", zone = "Europe/Warsaw")
    public void dailyPlayerUpdate() {
        Role premiumRole = roleRepository.findByName(PREMIUM_ROLE);
        playerRepository.findAll().forEach(player -> {
            progressPremium(player, premiumRole);
            resetStamina(player);
            playerRepository.save(player);
        });

    }

    private void progressPremium(Player player, Role premiumRole) {
        if (player.getPremiumLeft() == 0) {
            player.getRoles().remove(premiumRole);
        } else if (player.getPremiumLeft() > 0) {
            player.setPremiumLeft(player.getPremiumLeft() - 1);
            player.getRoles().add(premiumRole);
        }
    }

    private void resetStamina(Player player) {
        if (player.getStamina() < DEFAULT_STAMINA_AMOUNT) {
            player.setStamina(DEFAULT_STAMINA_AMOUNT);
        }
    }
}
