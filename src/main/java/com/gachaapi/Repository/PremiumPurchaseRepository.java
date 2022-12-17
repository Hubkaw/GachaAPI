package com.gachaapi.Repository;

import com.gachaapi.Entity.PremiumPurchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PremiumPurchaseRepository extends JpaRepository<PremiumPurchase, Integer> {
}
