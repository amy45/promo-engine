package com.example.promo.engine;

import com.example.promo.engine.enums.SKUTYPE;
import com.example.promo.engine.models.SKU;
import com.example.promo.engine.services.PromotionService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Amit Jethwani
 */
public class PromoEngine {
    public static void main(String[] args) {
        List<SKU> orderList = new ArrayList<>();
        SKU skuA = new SKU(SKUTYPE.A);
        SKU skuB = new SKU(SKUTYPE.B);
        SKU skuC = new SKU(SKUTYPE.C);
        SKU skuD = new SKU(SKUTYPE.D);
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter units for SKU Type A:");
        int unitsA = myObj.nextInt();
        fillArray(unitsA, orderList, skuA);
        System.out.println("Enter units for SKU Type B:");
        int unitsB = myObj.nextInt();
        fillArray(unitsB, orderList, skuB);
        System.out.println("Enter units for SKU Type C:");
        int unitsC = myObj.nextInt();
        fillArray(unitsC, orderList, skuC);
        System.out.println("Enter units for SKU Type D:");
        int unitsD = myObj.nextInt();
        fillArray(unitsD, orderList, skuD);

        PromotionService service = new PromotionService();
        long result = service.getTotalPrice(orderList);
        System.out.println("Total Count:" + result);

    }

    public static void fillArray(int count, List<SKU> orderList, SKU sku) {
        for (int i = 0; i < count; i++) {
            orderList.add(sku);
        }
    }
}
