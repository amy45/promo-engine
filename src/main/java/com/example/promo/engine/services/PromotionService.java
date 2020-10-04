package com.example.promo.engine.services;

import com.example.promo.engine.enums.SKUTYPE;
import com.example.promo.engine.models.PromotionRules;
import com.example.promo.engine.models.SKU;
import com.example.promo.engine.utils.PromoRulesCalculator;

import java.util.HashMap;
import java.util.List;
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

    public long getTotalPrice(List<SKU> skuList) {
        Map<SKUTYPE, Integer> hm = new HashMap<>();
        for (SKU i : skuList) {
            Integer j = hm.get(i.getName());
            hm.put(i.getName(), (j == null) ? 1 : j + 1);
        }
        int countA = hm.getOrDefault(SKUTYPE.A, 0);
        int countB = hm.getOrDefault(SKUTYPE.B, 0);
        int countC = hm.getOrDefault(SKUTYPE.C, 0);
        int countD = hm.getOrDefault(SKUTYPE.D, 0);
        int priceCD = 0;
        Map<SKUTYPE, PromotionRules> rulesMap = PromoRulesCalculator.getPromotionRulesMap();
        long totalPriceOfC = 0;
        long totalPriceOfD = 0;
        if (countC != 0 && countD != 0) {
            if (countC == countD)
                priceCD = countC * PromoRulesCalculator.getCombinedPromo("CD");
            else {
                if (countC < countD) {
                    priceCD = (countD - countC) * skuPriceMap.get(SKUTYPE.D) + countC * PromoRulesCalculator.getCombinedPromo("CD");
                } else {
                    priceCD = (countC - countD) * skuPriceMap.get(SKUTYPE.C) + countD * PromoRulesCalculator.getCombinedPromo("CD");
                }
            }
        } else {
            totalPriceOfC = (countC * skuPriceMap.get(SKUTYPE.C));
            totalPriceOfD = (countD * skuPriceMap.get(SKUTYPE.D));
        }
        long totalPriceOfA = (countA / rulesMap.get(SKUTYPE.A).getUnits()) * rulesMap.get(SKUTYPE.A).getPrice() + (countA % rulesMap.get(SKUTYPE.A).getUnits() * skuPriceMap.get(SKUTYPE.A));
        long totalPriceOfB = (countB / rulesMap.get(SKUTYPE.B).getUnits()) * rulesMap.get(SKUTYPE.B).getPrice() + (countB % rulesMap.get(SKUTYPE.B).getUnits() * skuPriceMap.get(SKUTYPE.B));

        return totalPriceOfA + totalPriceOfB + totalPriceOfC + totalPriceOfD + priceCD;
    }
}
