package com.gachaapi.Service.impl;

import com.gachaapi.Entity.*;
import com.gachaapi.Repository.*;
import com.gachaapi.Service.interfaces.PlayerCharacterService;
import com.gachaapi.Utils.ArtefactType;
import com.gachaapi.Utils.api.CharacterEquipment;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

@Service
@AllArgsConstructor
public class PlayerCharacterServiceImpl implements PlayerCharacterService {

    private PlayerRepository playerRepository;
    private PlayerCharacterRepository playerCharacterRepository;
    private PlayerArtefactRepository playerArtefactRepository;
    private PlayerWeaponRepository playerWeaponRepository;
    private PlayerMaterialRepository playerMaterialRepository;

    @Override
    public List<PlayerCharacter> getPlayerCharacters(String nickname) {
        Player player = playerRepository.findByNick(nickname).orElseThrow();
        return playerCharacterRepository.findAllByPlayer_IdPlayer(player.getIdPlayer());
    }

    @Override
    public PlayerCharacter changeCharacterEquipment(CharacterEquipment characterEquipment, String nick) {

        // Character checks
        Optional<PlayerCharacter> playerCharacterOptional = playerCharacterRepository.findById(characterEquipment.getCharacterId());
        if (playerCharacterOptional.isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This character does not exist");

        PlayerCharacter playerCharacter = playerCharacterOptional.get();

        if (!playerCharacter.getPlayer().getNick().equals(nick))
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "This character does not belong to you");

        // Weapon handling
        if (characterEquipment.getWeaponId() > 0) {
            Optional<PlayerWeapon> weaponOptional = playerWeaponRepository.findById(characterEquipment.getWeaponId());
            weaponOptional.ifPresent(weapon -> {
                if (!weapon.getPlayer().getNick().equals(nick))
                    throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "This weapon does not belong to you");
                if (weapon.getWieldingCharacter() != null)
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This weapon is already used by " + weapon.getWieldingCharacter().getCharacter().getName());
                if (!weapon.getWeapon().getWeaponClass().equals(playerCharacter.getCharacter().getCharacterClass().getWeaponClass()))
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This character cant wield a "+weapon.getWeapon().getWeaponClass().getName());
                playerCharacter.setWieldedWeapon(weapon);
                System.out.println("fjut");
                playerCharacterRepository.save(playerCharacter);
            });
        }


        // Artefacts handling
        if (playerCharacter.getPlayerArtefacts() == null)
            playerCharacter.setPlayerArtefacts(new HashSet<>());

        if (characterEquipment.getGlassesId() > 0) {
            Optional<PlayerArtefact> glassesOptional = playerArtefactRepository.findById(characterEquipment.getGlassesId());
            glassesOptional.ifPresent(glasses -> {
                if (glasses.getArtefact().getType() != ArtefactType.GLASSES)
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Requested " + glasses.getArtefact().getType().name() + " in " + ArtefactType.GLASSES.name() + " slot");
                if (!glasses.getPlayer().getNick().equals(nick))
                    throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "This artefact does not belong to you");
                playerCharacter.getPlayerArtefacts().removeIf(art -> art.getArtefact().getType() == ArtefactType.GLASSES);
                playerCharacter.getPlayerArtefacts().add(glasses);
            });
        }

        if (characterEquipment.getHatId() > 0) {
            Optional<PlayerArtefact> hatOptional = playerArtefactRepository.findById(characterEquipment.getHatId());
            hatOptional.ifPresent(hat -> {
                if (hat.getArtefact().getType() != ArtefactType.HAT)
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Requested " + hat.getArtefact().getType().name() + " in " + ArtefactType.HAT.name() + " slot");
                if (!hat.getPlayer().getNick().equals(nick))
                    throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "This artefact does not belong to you");
                playerCharacter.getPlayerArtefacts().removeIf(art -> art.getArtefact().getType() == ArtefactType.HAT);
                playerCharacter.getPlayerArtefacts().add(hat);
            });
        }

        if (characterEquipment.getRingId() > 0) {
            Optional<PlayerArtefact> ringOptional = playerArtefactRepository.findById(characterEquipment.getRingId());
            ringOptional.ifPresent(ring -> {
                if (ring.getArtefact().getType() != ArtefactType.RING)
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Requested " + ring.getArtefact().getType().name() + " in " + ArtefactType.RING.name() + " slot");
                if (!ring.getPlayer().getNick().equals(nick))
                    throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "This artefact does not belong to you");
                playerCharacter.getPlayerArtefacts().removeIf(art -> art.getArtefact().getType() == ArtefactType.RING);
                playerCharacter.getPlayerArtefacts().add(ring);
            });
        }

        return playerCharacterRepository.save(playerCharacter);
    }

    @Override
    public PlayerCharacter levelUp(int characterId, String nickname) {
        PlayerCharacter playerCharacter = playerCharacterRepository.getReferenceById(characterId);
        if (!playerCharacter.getPlayer().getNick().equals(nickname)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "This character does not belong to you");
        }
        Player player = playerRepository.findByNick(nickname).orElseThrow();

        Map<Material, Integer> requiredMaterials = new HashMap<>();
        playerCharacter.getCharacter().getAffilation().getMaterialAffilations().forEach(ma -> {
            int amount = ma.getBaseAmount();
            amount += (playerCharacter.getLvl() * ma.getPerLvlAmount()); // ilość = baza + level * perLvl
            requiredMaterials.put(ma.getMaterial(), amount);
        });
        playerCharacter.getCharacter().getCharacterClass().getMaterialClasses().forEach(mc -> {
            int amount = mc.getBaseAmount();
            amount += (playerCharacter.getLvl() * mc.getPerLvlAmount()); // ilość = baza + level * perLvl
            requiredMaterials.put(mc.getMaterial(), amount);
        });

        if (requiredMaterials.isEmpty())
            throw new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED, "This character cant be leveled up");

        // Check if player has enough materials
        requiredMaterials.forEach(((material, amount) -> {
            if (player.getPlayerMaterials().stream().noneMatch(pm -> pm.getMaterial().equals(material) && pm.getAmount() >= amount)) {
                StringBuilder sb = new StringBuilder("You dont have enough materials:\n");
                requiredMaterials.forEach((reqMaterial, reqAmount) -> sb.append(reqMaterial.getName()).append(" ").append(reqAmount).append("\n"));
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, sb.toString());
            }
        }));

        // Charge materials from player's account
        player.getPlayerMaterials().forEach(pm -> {
            if (requiredMaterials.containsKey(pm.getMaterial())) {
                pm.setAmount(pm.getAmount() - requiredMaterials.get(pm.getMaterial()));
                playerMaterialRepository.save(pm);
            }
        });

        playerCharacter.setLvl(playerCharacter.getLvl() + 1);
        return playerCharacterRepository.save(playerCharacter);
    }


}
