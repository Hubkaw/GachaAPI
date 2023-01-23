package com.gachaapi.Service.impl;

import com.gachaapi.Entity.*;
import com.gachaapi.Entity.Set;
import com.gachaapi.Repository.*;
import com.gachaapi.Service.interfaces.PlayerCharacterService;
import com.gachaapi.Utils.ArtefactType;
import com.gachaapi.Utils.ChangeArtefact;
import com.gachaapi.Utils.CharacterArtefacts;
import com.gachaapi.Utils.WeaponChange;
import com.gachaapi.Utils.api.CharacterEquipment;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicBoolean;

@Service
@AllArgsConstructor
public class PlayerCharacterServiceImpl implements PlayerCharacterService {

    private PlayerRepository playerRepository;
    private PlayerCharacterRepository playerCharacterRepository;
    private PlayerArtefactRepository playerArtefactRepository;
    private PlayerWeaponRepository playerWeaponRepository;
    private PlayerMaterialRepository playerMaterialRepository;
    private StatisticRepository statisticRepository;

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
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This character cant wield a " + weapon.getWeapon().getWeaponClass().getName());
                playerCharacter.setWieldedWeapon(weapon);
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
        PlayerCharacter playerCharacter = playerCharacterRepository.findById(characterId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "This character does not belong to you")
        );
        if (!playerCharacter.getPlayer().getNick().equals(nickname)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "This character does not belong to you");
        }
        Player player = playerRepository.findByNick(nickname).orElseThrow();

        Map<Material, Integer> requiredMaterials = new HashMap<>();
        playerCharacter.getCharacter().getAffilation().getMaterialAffilations().forEach(ma -> {
            int amount = ma.getBaseAmount() + (playerCharacter.getLvl() * ma.getPerLvlAmount());
            requiredMaterials.put(ma.getMaterial(), amount);
        });
        playerCharacter.getCharacter().getCharacterClass().getMaterialClasses().forEach(mc -> {
            int amount = mc.getBaseAmount() + (playerCharacter.getLvl() * mc.getPerLvlAmount());
            if (requiredMaterials.containsKey(mc.getMaterial())) {
                Integer oldAmount = requiredMaterials.get(mc.getMaterial());
                requiredMaterials.put(mc.getMaterial(), oldAmount + amount);
            } else {
                requiredMaterials.put(mc.getMaterial(), amount);
            }
        });

        if (requiredMaterials.isEmpty())
            throw new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED, "This character cant be leveled up");

        // Check if player has enough materials
        requiredMaterials.forEach(((material, amount) -> {
            if (player.getPlayerMaterials().stream().noneMatch(pm -> pm.getMaterial().equals(material) && pm.getAmount() >= amount)) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You dont have enough materials");
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

    @Override
    public PlayerCharacter getSafeById(int id, String nickname) {
        PlayerCharacter pc = playerCharacterRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "This character does not exist"));
        if (!pc.getPlayer().getNick().equals(nickname)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "This character does not belong to you");
        }
        return pc;
    }

    @Override
    public Map<String, Integer> getTotalStats(int id, String nickname) {
        PlayerCharacter pc = playerCharacterRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "This character does not exist"));
        if (!pc.getPlayer().getNick().equals(nickname)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "This character does not belong to you");
        }
        Map<String, Integer> result = new HashMap<>();
        for (Statistic statistic : statisticRepository.findAll()) {
            result.put(statistic.getShortName(), 0);
        }
        for (StatClass cs : pc.getCharacter().getCharacterClass().getStats()) {
            result.put(cs.getStat().getShortName(), result.get(cs.getStat().getShortName()) + (cs.getValue() * pc.getLvl()));
        }

        if (pc.getWieldedWeapon() != null) {
            for (StatWeapon stat : pc.getWieldedWeapon().getWeapon().getStats()) {
                result.put(stat.getStat().getShortName(), result.get(stat.getStat().getShortName()) + (stat.getValue() * pc.getWieldedWeapon().getLvl()));
            }
        }

        if (pc.getPlayerArtefacts().isEmpty()) {
            return result;
        }

        java.util.Set<Set> sets = new HashSet<>(pc.getPlayerArtefacts().stream().findFirst().get().getArtefact().getSets());

        for (PlayerArtefact pa : pc.getPlayerArtefacts()) {
            for (StatArtifact sa : pa.getArtefact().getStatArtifacts()) {
                result.put(sa.getStats().getShortName(), result.get(sa.getStats().getShortName()) + (sa.getValue() * pa.getLvl()));
            }

            sets.retainAll(pa.getArtefact().getSets());
        }
        if (pc.getPlayerArtefacts().size() == 3) {
            for (Set set : sets) {
                for (StatArtefactset sas : set.getStats()) {
                    if (result.containsKey(sas.getStat().getShortName())) {
                        result.put(sas.getStat().getShortName(), result.get(sas.getStat().getShortName()) + sas.getValue());
                    } else {
                        result.put(sas.getStat().getShortName(), sas.getValue());
                    }
                }
            }
        }
        return result;
    }

    @Override
    public Map<Material, Integer> getLevelUpCosts(int id, String nickname) {
        PlayerCharacter pc = playerCharacterRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "This character does not exist")
        );

        Map<Material, Integer> out = new HashMap<>();
        Collection<Materialclass> materialClasses = pc.getCharacter().getCharacterClass().getMaterialClasses();
        for (Materialclass materialClass : materialClasses) {
            if (out.containsKey(materialClass.getMaterial())){
                int amount = out.get(materialClass.getMaterial());
                amount += materialClass.getBaseAmount() + (materialClass.getPerLvlAmount() * pc.getLvl());

                out.put(materialClass.getMaterial(), amount);
            } else {
                out.put(materialClass.getMaterial(), materialClass.getBaseAmount() + (materialClass.getPerLvlAmount()*pc.getLvl()));
            }
        }

        Collection<Materialaffilation> materialAffilations = pc.getCharacter().getAffilation().getMaterialAffilations();
        for (Materialaffilation materialAffilation : materialAffilations) {
            if (out.containsKey(materialAffilation.getMaterial())){
                int amount = out.get(materialAffilation.getMaterial());
                amount += materialAffilation.getBaseAmount() + (materialAffilation.getPerLvlAmount() * pc.getLvl());

                out.put(materialAffilation.getMaterial(), amount);
            } else {
                out.put(materialAffilation.getMaterial(), materialAffilation.getBaseAmount() + (materialAffilation.getPerLvlAmount()*pc.getLvl()));
            }
        }


        return out;
    }

    @Override
    public void changeWeapon(WeaponChange weaponChange, String nickname) {
        Player player = playerRepository.findByNick(nickname).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Incorrect user"));
        PlayerCharacter pc = playerCharacterRepository.findById(weaponChange.getCharacterId()).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "This character does not exist"));
        if (!pc.getPlayer().getNick().equals(nickname)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "This character does not belong to you");
        }
        if (weaponChange.getWeaponId() > 0) {
            PlayerWeapon pw = playerWeaponRepository.findById(weaponChange.getWeaponId()).orElseThrow(() ->
                    new ResponseStatusException(HttpStatus.NOT_FOUND, "This weapon does not exist"));
            if (!pw.getPlayer().getNick().equals(nickname)) {
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "This weapon does not belong to you");
            }
            if (!pw.getWeapon().getWeaponClass().equals(pc.getCharacter().getCharacterClass().getWeaponClass())) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This character cannot wield ths weapon");
            }
            if (pw.getWieldingCharacter() != null) {
                PlayerCharacter wieldingCharacter = pw.getWieldingCharacter();
                wieldingCharacter.setWieldedWeapon(null);
                playerCharacterRepository.saveAndFlush(wieldingCharacter);

            }
            if (pc.getWieldedWeapon() != null) {
                PlayerWeapon wieldedWeapon = pc.getWieldedWeapon();
                wieldedWeapon.setWieldingCharacter(null);
                playerWeaponRepository.saveAndFlush(wieldedWeapon);
            }

            pc.setWieldedWeapon(pw);
            pw.setWieldingCharacter(pc);
            playerWeaponRepository.saveAndFlush(pw);
        } else {
            if (pc.getWieldedWeapon() != null) {
                PlayerWeapon wieldedWeapon = pc.getWieldedWeapon();
                PlayerCharacter wieldingCharacter = wieldedWeapon.getWieldingCharacter();
                wieldingCharacter.setWieldedWeapon(null);
                wieldedWeapon.setWieldingCharacter(null);
                playerCharacterRepository.saveAndFlush(wieldingCharacter);
                playerWeaponRepository.saveAndFlush(wieldedWeapon);
            }
            pc.setWieldedWeapon(null);
        }
        playerCharacterRepository.saveAndFlush(pc);
    }

    @Override
    public CharacterArtefacts getCharacterArtefacts(int id, String nickname) {
        PlayerCharacter pc = playerCharacterRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "This character does not exist"));
        if (!pc.getPlayer().getNick().equals(nickname)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "This character does not belong to you");
        }

        if (pc.getPlayerArtefacts().isEmpty()) {
            return new CharacterArtefacts(null, null, null);
        }
        java.util.Set<PlayerArtefact> artefacts = pc.getPlayerArtefacts();
        CharacterArtefacts ca = new CharacterArtefacts();
        if (artefacts.stream().anyMatch(a -> a.getArtefact().getType() == ArtefactType.RING)) {
            ca.setRing(artefacts.stream()
                    .filter(playerArtefact -> playerArtefact.getArtefact().getType() == ArtefactType.RING)
                    .findFirst().get());
        }

        if (artefacts.stream().anyMatch(a -> a.getArtefact().getType() == ArtefactType.GLASSES)) {
            ca.setGlasses(artefacts.stream()
                    .filter(playerArtefact -> playerArtefact.getArtefact().getType() == ArtefactType.GLASSES)
                    .findFirst().get());
        }

        if (artefacts.stream().anyMatch(a -> a.getArtefact().getType() == ArtefactType.HAT)) {
            ca.setHat(artefacts.stream()
                    .filter(playerArtefact -> playerArtefact.getArtefact().getType() == ArtefactType.HAT)
                    .findFirst().get());
        }

        return ca;
    }

    @Override
    public void changeArtefact(ChangeArtefact changeArtefact, String name) {
        PlayerCharacter pc = playerCharacterRepository.findById(changeArtefact.getCharacterId()).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "This Character does not exist"));
        if (!pc.getPlayer().getNick().equals(name)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "This character does not belong to you");
        }
        if (changeArtefact.getOldArtefactId() > 0) {
            PlayerArtefact oldArtefact = playerArtefactRepository.findById(changeArtefact.getOldArtefactId()).orElseThrow(() ->
                    new ResponseStatusException(HttpStatus.NOT_FOUND, "This artefact does not exist"));
            oldArtefact.getPlayerCharacters().clear();
            playerArtefactRepository.saveAndFlush(oldArtefact);
            pc.getPlayerArtefacts().remove(oldArtefact);

        }
        if (changeArtefact.getArtefactId()>0) {
            PlayerArtefact pa = playerArtefactRepository.findById(changeArtefact.getArtefactId()).orElseThrow(() ->
                    new ResponseStatusException(HttpStatus.NOT_FOUND, "This artefact does not exist"));
            if (!pa.getPlayer().getNick().equals(name)) {
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "This artefact does not belong to you");
            }

            pa.getPlayerCharacters().clear();
            playerArtefactRepository.saveAndFlush(pa);
            pc.getPlayerArtefacts().add(pa);
            playerCharacterRepository.saveAndFlush(pc);
        }
    }


}
