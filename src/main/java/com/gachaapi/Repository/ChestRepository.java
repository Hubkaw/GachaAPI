package com.gachaapi.Repository;

import com.gachaapi.Entity.Chest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface ChestRepository extends JpaRepository<Chest, Integer> {
    List<Chest> findAllByExpiresAtIsAfterAndReleasedAtBefore(Timestamp expirationAfter, Timestamp releasedBefore);
}
