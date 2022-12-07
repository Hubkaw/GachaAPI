package com.gachaapi.Repository;

import com.gachaapi.Entity.Weaponclass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeaponClassRepository extends JpaRepository<Weaponclass, Integer> {

}
