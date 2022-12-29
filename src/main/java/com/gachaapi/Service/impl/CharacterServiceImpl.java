package com.gachaapi.Service.impl;

import com.gachaapi.Entity.Ability;
import com.gachaapi.Entity.Character;
import com.gachaapi.Repository.*;
import com.gachaapi.Service.interfaces.CharacterService;
import com.gachaapi.Utils.AbilityType;
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
    private AbilityRepository abilityRepository;
    private StatisticRepository statisticRepository;

    @Override
    public List<Character> getAll() {
        return characterRepository.findAll();
    }

    @Override
    public void create(NewCharacter newCharacter) {
        Character character = new Character();
        character.setName(newCharacter.getName());

        Ability ability = new Ability();
        ability.setPotency(newCharacter.getAbilityPotency());
        ability.setName(newCharacter.getName());
        ability.setType(newCharacter.getAbilityType());
        if (ability.getType()!=AbilityType.ATTACK && newCharacter.getAbilityStatId().isPresent()){
            ability.setStat(statisticRepository.getReferenceById(newCharacter.getAbilityStatId().get()));
        }
        character.setAbility(ability);

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
