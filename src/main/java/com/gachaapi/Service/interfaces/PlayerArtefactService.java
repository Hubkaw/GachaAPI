package com.gachaapi.Service.interfaces;

import com.gachaapi.Entity.PlayerArtefact;

import java.util.List;

public interface PlayerArtefactService {
    List<PlayerArtefact> getAll(String nickname);
    PlayerArtefact levelUp(int upgradedArtefactId, int destroyedArtefactId, String nickname);
}
