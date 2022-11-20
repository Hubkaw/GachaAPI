package com.gachaapi.Repository;

import com.gachaapi.Entity.Chest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.List;

public interface ChestRepository extends JpaRepository<Chest, Integer> {
    List<Chest> findAllByExpiresAtIsAfterAndReleasedAtBefore(Timestamp expirationAfter, Timestamp releasedBefore);
}
