package com.gachaapi.Repository;

import com.gachaapi.Entity.PlayerWeapon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerWeaponRepository extends JpaRepository<PlayerWeapon, Integer> {
}
