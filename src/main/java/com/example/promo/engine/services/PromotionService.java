package com.example.promo.engine.services;

import com.example.promo.engine.enums.SKUTYPE;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Amit Jethwani
 */
public class PromotionService {

    private static Map<SKUTYPE, Integer> skuPriceMap = new HashMap<>();

    static {
        skuPriceMap.put(SKUTYPE.A, 50);
        skuPriceMap.put(SKUTYPE.B, 30);
        skuPriceMap.put(SKUTYPE.C, 20);
        skuPriceMap.put(SKUTYPE.D, 15);
    }

    public int getPriceByType(SKUTYPE c) {
        return skuPriceMap.getOrDefault(c, 0);
    }
}
