package com.gachaapi.Service.interfaces;


import com.gachaapi.Entity.Material;
import com.gachaapi.Entity.PlayerCharacter;
import com.gachaapi.Utils.ChangeArtefact;
import com.gachaapi.Utils.CharacterArtefacts;
import com.gachaapi.Utils.PartyCharacterChange;
import com.gachaapi.Utils.WeaponChange;
import com.gachaapi.Utils.api.CharacterEquipment;

import java.util.List;
import java.util.Map;

public interface PlayerCharacterService {
    List<PlayerCharacter> getPlayerCharacters(String nickname);
    PlayerCharacter changeCharacterEquipment(CharacterEquipment characterEquipment, String nick);
    PlayerCharacter levelUp(int characterId, String nickname);

    PlayerCharacter getSafeById(int id, String nickname);
    Map<String, Integer> getTotalStats(int id, String nickname);
    Map<Material, Integer> getLevelUpCosts(int id, String nickname);
    void changeWeapon(WeaponChange weaponChange, String nickname);

    CharacterArtefacts getCharacterArtefacts(int id, String nickname);

    void changeArtefact(ChangeArtefact changeArtefact, String name);

}
