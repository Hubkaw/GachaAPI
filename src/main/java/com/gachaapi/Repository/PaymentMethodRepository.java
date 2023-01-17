package com.gachaapi.Repository;

import com.gachaapi.Entity.Paymentmethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentMethodRepository extends JpaRepository<Paymentmethod, Integer> {

}

