package com.gachaapi.Service.impl;

import com.gachaapi.Entity.PlayerMaterial;
import com.gachaapi.Repository.PlayerMaterialRepository;
import com.gachaapi.Service.interfaces.PlayerMaterialService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PlayerMaterialServiceImpl implements PlayerMaterialService {

    private PlayerMaterialRepository playerMaterialRepository;

    @Override
    public List<PlayerMaterial> getAll(String nickname) {
        return playerMaterialRepository.findAllByPlayerNick(nickname);
    }
}
