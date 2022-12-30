package com.gachaapi.Service.impl;

import com.gachaapi.Entity.Party;
import com.gachaapi.Entity.Player;
import com.gachaapi.Entity.PlayerCharacter;
import com.gachaapi.Repository.PartyRepository;
import com.gachaapi.Repository.PlayerCharacterRepository;
import com.gachaapi.Repository.PlayerRepository;
import com.gachaapi.Service.interfaces.PlayerPartyService;
import com.gachaapi.Utils.api.NewParty;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashSet;
import java.util.List;

@Service
@AllArgsConstructor
public class PlayerPartyServiceImpl implements PlayerPartyService {

    private PartyRepository partyRepository;
    private PlayerRepository playerRepository;
    private PlayerCharacterRepository playerCharacterRepository;

    @Override
    public List<Party> getAll(String nickname) {
        return partyRepository.findAllByPlayerNick(nickname);
    }

    @Override
    public Party createParty(NewParty newParty, String nickname) {

        Player player = playerRepository.findByNick(nickname).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This account is invalid");
        });

        if(newParty.getName().length()>32){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Party Name too long");
        }

        List<Integer> charIds = List.of(newParty.getChar1Id(), newParty.getChar2Id(), newParty.getChar3Id(), newParty.getChar4Id());
        HashSet<PlayerCharacter> characters = new HashSet<>();
        charIds.forEach(id -> {
            PlayerCharacter playerCharacter = playerCharacterRepository.findById(id).orElseThrow(() ->
                    new ResponseStatusException(HttpStatus.BAD_REQUEST, "Character of id: " + id + " doeas not exist")
            );
            if (!playerCharacter.getPlayer().equals(player)){
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "This character does not belong to you");
            }
            if (characters.stream().anyMatch(pc -> pc.getCharacter().equals(playerCharacter.getCharacter()))){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You cannot have the same character twice in a party: "+ playerCharacter.getCharacter().getName());
            }
            characters.add(playerCharacter);
        });


        Party party = new Party();
        party.setPlayer(player);
        party.setName(newParty.getName());
        party.setCharacters(characters);

        return partyRepository.save(party);
    }

    @Override
    public void deleteParty(int id, String nickname) {
        Party party = partyRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Party of this id doesnt exist"));
        if (!party.getPlayer().getNick().equals(nickname)){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "This party doesnt belong to you");
        }
        partyRepository.delete(party);
    }

    @Override
    public Player setActive(int id, String nickname) {
        Player player = playerRepository.findByNick(nickname).orElseThrow();

        Party party = partyRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.BAD_REQUEST, "This party does not exist"));
        if (!party.getPlayer().equals(player)){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "This Party does not belong to you");
        }
        if (party.getCharacters().size()!=4){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This Party is invalid senpai.");
        }

        player.setActiveParty(id);
        return playerRepository.save(player);
    }
}
