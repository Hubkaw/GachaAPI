package com.gachaapi.Service.interfaces;


import com.gachaapi.Entity.PlayerCharacter;
import com.gachaapi.Utils.api.CharacterEquipment;

import java.util.List;

public interface PlayerCharacterService {
    List<PlayerCharacter> getPlayerCharacters(String nickname);
    PlayerCharacter changeCharacterEquipment(CharacterEquipment characterEquipment, String nick);
    PlayerCharacter levelUp(int characterId, String nickname);
}
