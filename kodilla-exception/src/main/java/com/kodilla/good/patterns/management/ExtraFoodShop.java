package com.kodilla.good.patterns.management;
import java.util.HashMap;

public class ExtraFoodShop implements Producer{

    @Override
    public void process(String supplierInfo, HashMap<String, Integer> productInfo) {
        System.out.println("Zamówienie w ExtraFoodShop ");
        System.out.println("Dostawca : " + supplierInfo);
        for (String product : productInfo.keySet()) {
            int quantity = productInfo.get(product);
            System.out.println(product + " : " + quantity);
        }
        System.out.println("Zamówienie zrealizowane ");
        System.out.println("-----------------------------");
    }
}
