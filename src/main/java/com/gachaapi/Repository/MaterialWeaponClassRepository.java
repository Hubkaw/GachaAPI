package com.gachaapi.Repository;

import com.gachaapi.Entity.Materialweaponclass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialWeaponClassRepository extends JpaRepository<Materialweaponclass, Integer> {
}
