package com.gachaapi.Repository;

import com.gachaapi.Entity.PlayerPurchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerPurchaseRepository extends JpaRepository<PlayerPurchase, Integer> {

}
