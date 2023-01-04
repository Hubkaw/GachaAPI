package com.gachaapi.Service.impl;

import com.gachaapi.Entity.PlayerArtefact;
import com.gachaapi.Repository.PlayerArtefactRepository;
import com.gachaapi.Service.interfaces.PlayerArtefactService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class PlayerArtefactServiceImpl implements PlayerArtefactService {

    private PlayerArtefactRepository playerArtefactRepository;

    @Override
    public List<PlayerArtefact> getAll(String nickname) {
        return playerArtefactRepository.findAllByPlayerNick(nickname);
    }

      @Override
    public PlayerArtefact levelUp(int upgradedArtefactId, int destroyedArtefactId, String nickname) {
        if (upgradedArtefactId == destroyedArtefactId){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You cannot do this");
        }

        PlayerArtefact destroyedArtefact = playerArtefactRepository.findById(destroyedArtefactId).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "This artefact does not exist"));
        PlayerArtefact upgradedArtefact = playerArtefactRepository.findById(upgradedArtefactId).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "This artefact does not exist"));

        if (!destroyedArtefact.getPlayer().getNick().equals(nickname) || !upgradedArtefact.getPlayer().getNick().equals(nickname)){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "This artefact does not belong to you");
        }
        if (!upgradedArtefact.getArtefact().equals(destroyedArtefact.getArtefact())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This is not a duplicate");
        }
        if (destroyedArtefact.getPlayerCharacters().size()>0){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This artefact is worn by:"+
                    destroyedArtefact.getPlayerCharacters().stream().findAny().get().getCharacter().getName()+" lvl:"+
                    destroyedArtefact.getPlayerCharacters().stream().findAny().get().getLvl());
        }

        upgradedArtefact.setLvl(upgradedArtefact.getLvl()+1);
        playerArtefactRepository.delete(destroyedArtefact);

        return playerArtefactRepository.save(upgradedArtefact);
    }
}
