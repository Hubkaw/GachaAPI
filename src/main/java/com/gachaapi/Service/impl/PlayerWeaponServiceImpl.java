package com.gachaapi.Service.impl;

import com.gachaapi.Entity.*;
import com.gachaapi.Repository.PlayerMaterialRepository;
import com.gachaapi.Repository.PlayerRepository;
import com.gachaapi.Repository.PlayerWeaponRepository;
import com.gachaapi.Service.interfaces.PlayerWeaponService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;
import java.util.Collection;

@Service
@AllArgsConstructor
public class PlayerWeaponServiceImpl implements PlayerWeaponService {

    private PlayerWeaponRepository playerWeaponRepository;
    private PlayerRepository playerRepository;
    private PlayerMaterialRepository playerMaterialRepository;

    @Override
    public List<PlayerWeapon> getAll(String nickname) {
        return playerWeaponRepository.findAllByPlayerNick(nickname);
    }

    @Override
    public PlayerWeapon levelUp(int id, String nickname) {

        Player player = playerRepository.findByNick(nickname).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "This account is invalid")
        );
        PlayerWeapon playerWeapon = playerWeaponRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "This weapon does not exist"));
        if (!playerWeapon.getPlayer().getNick().equals(nickname)){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "This weapon does not belong to you");
        }

        // Get all required materials
        Collection<Materialelement> materialElements = playerWeapon.getWeapon().getElement().getMaterialElements();
        Collection<Materialweaponclass> materialWeaponClasses = playerWeapon.getWeapon().getWeaponClass().getMaterialWeaponClasses();
        Map<Material, Integer> requiredMaterials = new HashMap<>();
        materialElements.forEach(me -> {
            int amount = me.getBaseAmount() + (me.getPerLvlAmount() * playerWeapon.getLvl());
            requiredMaterials.put(me.getMaterial(), amount);
        });
        materialWeaponClasses.forEach(mw ->{
            int amount = mw.getBaseAmount() +(mw.getPerLvlAmount() * playerWeapon.getLvl());
            if (requiredMaterials.containsKey(mw.getMaterial())){
                Integer oldAmount = requiredMaterials.get(mw.getMaterial());
                requiredMaterials.put(mw.getMaterial(), oldAmount + amount);
            } else {
                requiredMaterials.put(mw.getMaterial(), amount);
            }
        });

        // check if player can afford the upgrade
        requiredMaterials.forEach(((material, amount) -> {
            if (player.getPlayerMaterials().stream().noneMatch(pm -> pm.getMaterial().equals(material) && pm.getAmount() >= amount)) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You dont have enough materials");
            }
        }));

        // Charge materials form player's account
        player.getPlayerMaterials().forEach(pm ->{
            if (requiredMaterials.containsKey(pm.getMaterial())){
                pm.setAmount(pm.getAmount() - requiredMaterials.get(pm.getMaterial()));
                playerMaterialRepository.save(pm);
            }
        });
        playerWeapon.setLvl(playerWeapon.getLvl()+1);
        return playerWeaponRepository.save(playerWeapon);
    }

    @Override
    public Map<PlayerWeapon, Map<Material, Integer>> getAllWithCost(String nickname) {
        List<PlayerWeapon> playerWeapons = playerWeaponRepository.findAllByPlayerNick(nickname);

        Map<PlayerWeapon, Map<Material, Integer>> out = new TreeMap<>((key, nextKey) -> {
            if (0 != key.getWeapon().getName().compareTo(nextKey.getWeapon().getName())){
                return key.getWeapon().getName().compareTo(nextKey.getWeapon().getName());
            }
            return Integer.compare(nextKey.getLvl(),key.getLvl());
        });

        for (PlayerWeapon playerWeapon : playerWeapons) {
            Map<Material, Integer> requiredMaterials = new HashMap<>();

            Collection<Materialweaponclass> materialWeaponClasses = playerWeapon.getWeapon().getWeaponClass().getMaterialWeaponClasses();
            for (Materialweaponclass materialWeaponClass : materialWeaponClasses) {
                if (requiredMaterials.containsKey(materialWeaponClass.getMaterial())){
                    int amount = requiredMaterials.get(materialWeaponClass.getMaterial());
                    amount += materialWeaponClass.getBaseAmount() + (materialWeaponClass.getPerLvlAmount() * playerWeapon.getLvl());

                    requiredMaterials.put(materialWeaponClass.getMaterial(), amount);
                } else {
                    requiredMaterials.put(materialWeaponClass.getMaterial(), materialWeaponClass.getBaseAmount() + (materialWeaponClass.getPerLvlAmount()*playerWeapon.getLvl()));
                }
            }
            Element element = playerWeapon.getWeapon().getElement();
            for (Materialelement materialElement : element.getMaterialElements()) {
            if (requiredMaterials.containsKey(materialElement.getMaterial())){
                    int amount = requiredMaterials.get(materialElement.getMaterial());
                    amount += materialElement.getBaseAmount() + (materialElement.getPerLvlAmount() * playerWeapon.getLvl());

                    requiredMaterials.put(materialElement.getMaterial(), amount);
                } else {
                    requiredMaterials.put(materialElement.getMaterial(), materialElement.getBaseAmount() + (materialElement.getPerLvlAmount()*playerWeapon.getLvl()));
                }
            }
            out.put(playerWeapon, requiredMaterials);
        }
        return out;
    }
}
