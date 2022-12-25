package com.gachaapi.Service.interfaces;

import com.gachaapi.Entity.PlayerMaterial;

import java.util.List;

public interface PlayerMaterialService {
    List<PlayerMaterial> getAll(String nickname);
}
