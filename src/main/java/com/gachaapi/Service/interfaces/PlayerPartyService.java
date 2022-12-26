package com.gachaapi.Service.interfaces;

import com.gachaapi.Entity.Party;
import com.gachaapi.Utils.api.NewParty;

import java.util.List;

public interface PlayerPartyService {
    List<Party> getAll(String nickname);
    Party createParty(NewParty newParty, String nickname);
    void deleteParty(int id, String nickname);
}
