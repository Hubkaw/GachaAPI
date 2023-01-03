package com.gachaapi.Service.interfaces;

import com.gachaapi.Entity.Party;
import com.gachaapi.Entity.Player;
import com.gachaapi.Utils.PartyCharacterChange;
import com.gachaapi.Utils.api.NewParty;

import java.util.List;

public interface PlayerPartyService {
    List<Party> getAll(String nickname);
    Party createParty(NewParty newParty, String nickname);
    void deleteParty(int id, String nickname);
    Player setActive(int id, String nickname);

    void changePartyCharacter(PartyCharacterChange pcc, String name);
}
