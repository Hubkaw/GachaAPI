package com.gachaapi.Service.impl;

import com.gachaapi.Entity.*;
import com.gachaapi.Repository.*;
import com.gachaapi.Service.interfaces.AdminCharacterService;
import com.gachaapi.Utils.dev.NewAdminCharacter;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashSet;
import java.util.List;

@Service
@AllArgsConstructor
public class AdminCharacterServiceImpl implements AdminCharacterService {

    private PlayerCharacterRepository playerCharacterRepository;
    private CharacterRepository characterRepository;
    private ArtefactRepository artefactRepository;
    private WeaponRepository weaponRepository;
    private PlayerWeaponRepository playerWeaponRepository;
    private PlayerArtefactRepository playerArtefactRepository;
    private PlayerRepository playerRepository;


    @Override
    public List<PlayerCharacter> getAll() {
        return playerCharacterRepository.findAllByPlayer_IdPlayer(1);
    }

    @Override
    public void create(NewAdminCharacter newAdminCharacter) {
        if (newAdminCharacter.getCharId() < 1 || newAdminCharacter.getCharLvl()<1){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid character or character level");
        }
        if(newAdminCharacter.getGlassesId()>=1 && newAdminCharacter.getGlassesLvl()<1){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Level must be above 0");
        }
        if(newAdminCharacter.getHatId()>=1 && newAdminCharacter.getHatLvl()<1){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Level must be above 0");
        }
        if(newAdminCharacter.getWeaponId()>=1 && newAdminCharacter.getWeaponLvl()<1){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Level must be above 0");
        }
        if(newAdminCharacter.getRingId()>=1 && newAdminCharacter.getRingLvl()<1){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Level must be above 0");
        }

        Player admin = playerRepository.findByNick("admin").orElseThrow();
        PlayerCharacter pc = new PlayerCharacter();
        pc.setPlayerArtefacts(new HashSet<>());
        if(newAdminCharacter.getGlassesId()!=-1){
            Artefact glasses = artefactRepository.getReferenceById(newAdminCharacter.getGlassesId());
            PlayerArtefact pa = new PlayerArtefact();
            pa.setArtefact(glasses);
            pa.setLvl(newAdminCharacter.getGlassesLvl());
            pa.setPlayer(admin);
            playerArtefactRepository.save(pa);
            pc.getPlayerArtefacts().add(pa);
        }
        if(newAdminCharacter.getHatId()!=-1 && newAdminCharacter.getHatLvl()>=1){
            Artefact hat = artefactRepository.findById(newAdminCharacter.getHatId()).orElseThrow();
            PlayerArtefact pa = new PlayerArtefact();
            pa.setArtefact(hat);
            pa.setLvl(newAdminCharacter.getHatLvl());
            pa.setPlayer(admin);
            playerArtefactRepository.save(pa);
            pc.getPlayerArtefacts().add(pa);
        }
        if(newAdminCharacter.getRingId()!=-1 && newAdminCharacter.getRingLvl()>=1){
            Artefact ring = artefactRepository.getReferenceById(newAdminCharacter.getRingId());
            PlayerArtefact pa = new PlayerArtefact();
            pa.setArtefact(ring);
            pa.setLvl(newAdminCharacter.getRingLvl());
            pa.setPlayer(admin);
            playerArtefactRepository.save(pa);
            pc.getPlayerArtefacts().add(pa);
        }
        if (newAdminCharacter.getWeaponId()!=-1 && newAdminCharacter.getWeaponLvl()>=1){
            PlayerWeapon pw = new PlayerWeapon();
            Weapon weapon = weaponRepository.getReferenceById(newAdminCharacter.getWeaponId());
            pw.setWeapon(weapon);
            pw.setLvl(newAdminCharacter.getWeaponLvl());
            pw.setPlayer(admin);
            playerWeaponRepository.save(pw);
            pc.setWieldedWeapon(pw);
        }
        pc.setCharacter(characterRepository.getReferenceById(newAdminCharacter.getCharId()));
        pc.setPlayer(admin);
        pc.setLvl(newAdminCharacter.getCharLvl());
        playerCharacterRepository.save(pc);
    }

    @Override
    public void delete(int id) {
        playerCharacterRepository.deleteById(id);
    }
}
