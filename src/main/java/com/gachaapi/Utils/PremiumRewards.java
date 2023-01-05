package com.gachaapi.Utils;

import com.gachaapi.Entity.Material;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@AllArgsConstructor
@Data
public class PremiumRewards {
    private Map<Material, Integer> materials;
    private int balance;
}
