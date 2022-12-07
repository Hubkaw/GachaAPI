package com.gachaapi.Repository;

import com.gachaapi.Entity.PlayerChestitem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerChestItemRepository extends JpaRepository<PlayerChestitem, Integer> {
}
