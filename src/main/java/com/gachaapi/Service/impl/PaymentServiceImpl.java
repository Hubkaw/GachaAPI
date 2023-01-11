package com.gachaapi.Service.impl;

import com.gachaapi.Entity.Ingamecurrencypurchase;
import com.gachaapi.Repository.InGameCurrencyPurchaseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PaymentServiceImpl implements com.gachaapi.Service.interfaces.PaymentService {

    private InGameCurrencyPurchaseRepository currencyPurchaseRepository;


    @Override
    public List<Ingamecurrencypurchase> getAll() {
        return currencyPurchaseRepository.findAll();
    }

    @Override
    public Ingamecurrencypurchase getById(int id) {
        return currencyPurchaseRepository.getReferenceById(id);
    }
}
