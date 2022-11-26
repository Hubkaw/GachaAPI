package com.gachaapi.Repository;

import com.gachaapi.Entity.Clazz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepository extends JpaRepository<Clazz, Integer> {
}
