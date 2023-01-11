package com.gachaapi.Service.interfaces;

import com.gachaapi.Entity.Ingamecurrencypurchase;


import java.util.List;

public interface PaymentService {
    List<Ingamecurrencypurchase> getAll();

    Ingamecurrencypurchase getById(int id);

}
