package com.gachaapi.Utils;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PremiumBuyOrder {
    private int amount;
    private int totalPrice;
}
