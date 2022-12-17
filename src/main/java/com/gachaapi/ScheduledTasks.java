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

import static com.gachaapi.Utils.Constants.PREMIUM_ROLE;

@EnableScheduling
@Component
@AllArgsConstructor
public class ScheduledTasks {

    private PlayerRepository playerRepository;
    private RoleRepository roleRepository;

    @Bean
    @Scheduled(cron = "0 0 3 * * *", zone="Europe/Warsaw")
    public void updatePremium(){
        List<Player> all = playerRepository.findAll();
        Role premiumRole = roleRepository.findByName(PREMIUM_ROLE);
        all.forEach(p ->{
            if (p.getPremiumLeft()==0){
                p.getRoles().remove(premiumRole);
            } else if (p.getPremiumLeft()>0){
                p.setPremiumLeft(p.getPremiumLeft()-1);
                p.getRoles().add(premiumRole);
            }
        });
        playerRepository.saveAll(all);
    }
}
