package com.gachaapi.Service.impl;

import com.gachaapi.Entity.*;
import com.gachaapi.Repository.*;
import com.gachaapi.Service.interfaces.AdminPartyService;
import com.gachaapi.Utils.dev.NewAdminParty;
import com.gachaapi.Utils.dev.NewArtefactReward;
import com.gachaapi.Utils.dev.NewMaterialReward;
import com.gachaapi.Utils.dev.NewWeaponReward;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashSet;
import java.util.List;

@AllArgsConstructor
@Service
public class AdminPartyServiceImpl implements AdminPartyService {

    private PartyRepository partyRepository;
    private DungeonFloorRepository dungeonFloorRepository;
    private DungeonRepository dungeonRepository;
    private PlayerCharacterRepository playerCharacterRepository;
    private PlayerRepository playerRepository;
    private ArtefactRewardRepository artefactRewardRepository;
    private WeaponRewardRepository weaponRewardRepository;
    private MaterialRewardRepository materialRewardRepository;
    private ArtefactRepository artefactRepository;
    private WeaponRepository weaponRepository;
    private MaterialRepository materialRepository;

    @Override
    public List<Party> getAllAdminParties() {
        return partyRepository.findAllByPlayer_IdPlayer(1);
    }

    @Override
    public List<Dungeonfloor> getAllDungeonFloors() {
        return dungeonFloorRepository.findAll();
    }

    @Override
    public void create(NewAdminParty newAdminParty) {

        Dungeon dungeon = dungeonRepository.findById(newAdminParty.getDungeon()).orElseThrow(
                () ->
                        new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dungeon of id "+newAdminParty.getChar1()+" doesnt exist.")
        );
        PlayerCharacter pc1 = playerCharacterRepository.findById(newAdminParty.getChar1()).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.BAD_REQUEST, "Character of id "+newAdminParty.getChar1()+" doesnt exist."));
        PlayerCharacter pc2 = playerCharacterRepository.findById(newAdminParty.getChar2()).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.BAD_REQUEST, "Character of id "+newAdminParty.getChar2()+" doesnt exist."));
        PlayerCharacter pc3 = playerCharacterRepository.findById(newAdminParty.getChar3()).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.BAD_REQUEST, "Character of id "+newAdminParty.getChar3()+" doesnt exist."));
        PlayerCharacter pc4 = playerCharacterRepository.findById(newAdminParty.getChar4()).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.BAD_REQUEST, "Character of id "+newAdminParty.getChar4()+" doesnt exist."));

        if(dungeonFloorRepository.findAllByDungeon(dungeon).stream().anyMatch(df -> df.getDepth() == newAdminParty.getDepth())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This dungeon already has a floor of depth "+newAdminParty.getDepth());
        }

        HashSet<PlayerCharacter> pcs = new HashSet<>();
        pcs.add(pc1);
        pcs.add(pc2);
        pcs.add(pc3);
        pcs.add(pc4);
        if (pcs.size()!=4)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Podaj 4 unikalne postacie");

        Party party = new Party();
        party.setName(newAdminParty.getName());
        party.setPlayer(playerRepository.getReferenceById(1));
        party.setCharacters(pcs);
        partyRepository.save(party);

        Dungeonfloor df = new Dungeonfloor();
        df.setDepth(newAdminParty.getDepth());
        df.setParty(party);
        df.setDungeon(dungeon);
        dungeonFloorRepository.save(df);
    }

    @Override
    public void delete(int id) {
        dungeonFloorRepository.deleteById(id);
    }

    @Override
    public Dungeonfloor getDungeonFloorById(int id) {
        return dungeonFloorRepository.getReferenceById(id);
    }

    @Override
    public void createArtefactReward(NewArtefactReward newArtefactReward) {
        ArtefactReward artefactReward = new ArtefactReward();
        artefactReward.setArtefact(artefactRepository.getReferenceById(newArtefactReward.getArtefactId()));
        artefactReward.setDungeonFloor(dungeonFloorRepository.getReferenceById(newArtefactReward.getDungeonFloorId()));
        artefactReward.setQuantity(newArtefactReward.getQuantity());
        artefactRewardRepository.save(artefactReward);
    }

    @Override
    public void createMaterialReward(NewMaterialReward newMaterialReward) {
        MaterialReward materialReward = new MaterialReward();
        materialReward.setMaterial(materialRepository.getReferenceById(newMaterialReward.getMaterialId()));
        materialReward.setDungeonFloor(dungeonFloorRepository.getReferenceById(newMaterialReward.getDungeonFloorId()));
        materialReward.setQuantity(newMaterialReward.getQuantity());
        materialRewardRepository.save(materialReward);
    }

    @Override
    public void createWeaponReward(NewWeaponReward newWeaponReward) {
        WeaponReward weaponReward = new WeaponReward();
        weaponReward.setWeapon(weaponRepository.getReferenceById(newWeaponReward.getWeaponId()));
        weaponReward.setDungeonFloor(dungeonFloorRepository.getReferenceById(newWeaponReward.getDungeonFloorId()));
        weaponReward.setQuantity(newWeaponReward.getQuantity());
        weaponRewardRepository.save(weaponReward);
    }

    @Override
    public void deleteArtefactReward(int id) {
        artefactRewardRepository.deleteById(id);
    }

    @Override
    public void deleteWeaponReward(int id) {
        weaponRewardRepository.deleteById(id);
    }

    @Override
    public void deleteMaterialReward(int id) {
        materialRewardRepository.deleteById(id);
    }


}
