package com.gachaapi.Service.interfaces;


import com.gachaapi.Entity.Dungeonfloor;
import com.gachaapi.Entity.Party;
import com.gachaapi.Utils.dev.NewAdminParty;
import com.gachaapi.Utils.dev.NewArtefactReward;
import com.gachaapi.Utils.dev.NewMaterialReward;
import com.gachaapi.Utils.dev.NewWeaponReward;

import java.util.List;

public interface AdminPartyService {

    List<Party> getAllAdminParties();
    List<Dungeonfloor> getAllDungeonFloors();
    void create(NewAdminParty newAdminParty);
    void delete(int id);
    Dungeonfloor getDungeonFloorById(int id);

    void createArtefactReward(NewArtefactReward newArtefactReward);
    void createMaterialReward(NewMaterialReward newMaterialReward);
    void createWeaponReward(NewWeaponReward newWeaponReward);

    void deleteArtefactReward(int id);
    void deleteWeaponReward(int id);
    void deleteMaterialReward(int id);

}
