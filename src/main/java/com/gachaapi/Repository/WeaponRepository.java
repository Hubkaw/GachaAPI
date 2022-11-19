package com.gachaapi.Repository;

import com.gachaapi.Entity.Weapon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeaponRepository extends JpaRepository<Weapon, Integer> {
}
