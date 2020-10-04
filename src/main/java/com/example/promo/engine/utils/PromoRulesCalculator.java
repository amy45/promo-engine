package com.example.promo.engine.utils;

import com.example.promo.engine.enums.SKUTYPE;
import com.example.promo.engine.models.PromotionRules;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Amit Jethwani
 */
public class PromoRulesCalculator {

    private static Map<SKUTYPE, PromotionRules> promotionRulesMap = new HashMap<>();

    public static Map<SKUTYPE, PromotionRules> getPromotionRulesMap() {

        promotionRulesMap.put(SKUTYPE.A, new PromotionRules(3, 130));

        promotionRulesMap.put(SKUTYPE.B, new PromotionRules(2, 45));

        promotionRulesMap.put(SKUTYPE.C, new PromotionRules(1, 30));

        promotionRulesMap.put(SKUTYPE.D, new PromotionRules(1, 30));

        return promotionRulesMap;
    }

    public static int getCombinedPromo(String regex) {
        int result = 0;
        switch (regex) {
            case "CD":
                result = 30;
                break;
        }
        return result;
    }
}
