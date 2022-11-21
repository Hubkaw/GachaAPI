package com.gachaapi.Repository;

import com.gachaapi.Entity.PlayerWeapon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerWeaponRepository extends JpaRepository<PlayerWeapon, Integer> {
}
