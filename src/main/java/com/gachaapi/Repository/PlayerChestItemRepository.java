package com.gachaapi.Repository;

import com.gachaapi.Entity.PlayerChestitem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerChestItemRepository extends JpaRepository<PlayerChestitem, Integer> {
}
