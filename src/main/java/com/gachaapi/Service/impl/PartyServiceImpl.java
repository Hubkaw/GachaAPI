package com.gachaapi.Service.impl;

import com.gachaapi.Entity.Party;
import com.gachaapi.Repository.PartyRepository;
import com.gachaapi.Service.interfaces.PartyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PartyServiceImpl implements PartyService {

    private PartyRepository partyRepository;

    @Override
    public Party getById(int id) {
        return partyRepository.getReferenceById(id);
    }
}
