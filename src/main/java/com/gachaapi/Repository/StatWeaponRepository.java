package com.gachaapi.Repository;

import com.gachaapi.Entity.StatWeapon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatWeaponRepository extends JpaRepository<StatWeapon, Integer> {
}
