package com.gachaapi.Service.interfaces;


import com.gachaapi.Entity.PremiumPurchase;

public interface PremiumService {
    PremiumPurchase buyPremium(String nickname, int days);
    int getPremiumDaysLeft(String nickname);
}
