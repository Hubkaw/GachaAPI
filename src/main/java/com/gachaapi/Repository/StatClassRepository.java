package com.gachaapi.Repository;

import com.gachaapi.Entity.StatClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatClassRepository extends JpaRepository<StatClass, Integer> {
}
