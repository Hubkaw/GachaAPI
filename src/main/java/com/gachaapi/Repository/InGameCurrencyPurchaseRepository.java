package com.gachaapi.Repository;

import com.gachaapi.Entity.Ingamecurrencypurchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InGameCurrencyPurchaseRepository extends JpaRepository<Ingamecurrencypurchase, Integer> {

    Ingamecurrencypurchase findByVolume(int value);
}
