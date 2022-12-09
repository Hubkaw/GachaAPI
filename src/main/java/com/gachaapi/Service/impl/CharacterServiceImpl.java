package com.gachaapi.Service.impl;

import com.gachaapi.Entity.Character;
import com.gachaapi.Repository.AffiliationRepository;
import com.gachaapi.Repository.CharacterRepository;
import com.gachaapi.Repository.ClassRepository;
import com.gachaapi.Repository.RarityRepository;
import com.gachaapi.Service.interfaces.CharacterService;
import com.gachaapi.Utils.dev.NewCharacter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CharacterServiceImpl implements CharacterService {

    private CharacterRepository characterRepository;
    private AffiliationRepository affiliationRepository;
    private ClassRepository classRepository;
    private RarityRepository rarityRepository;

    @Override
    public List<Character> getAll() {
        return characterRepository.findAll();
    }

    @Override
    public void create(NewCharacter newCharacter) {
        Character character = new Character();
        character.setName(newCharacter.getName());
        character.setAbility(newCharacter.getAbility());
        character.setAffilation(affiliationRepository.getReferenceById(newCharacter.getAffiliationId()));
        character.setCharacterClass(classRepository.getReferenceById(newCharacter.getClassId()));
        character.setRarity(rarityRepository.getReferenceById(newCharacter.getRarityId()));
        characterRepository.save(character);
    }
    @Override
    public void delete(int id) {
        Character character = characterRepository.getReferenceById(id);
        if(character.getPlayerCharactersById().isEmpty())
            characterRepository.deleteById(id);
    }
}
