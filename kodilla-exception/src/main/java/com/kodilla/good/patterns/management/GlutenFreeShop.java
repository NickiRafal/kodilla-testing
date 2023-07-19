package com.kodilla.good.patterns.management;
import java.util.HashMap;

public class GlutenFreeShop implements Producer{

    @Override
    public void process(String supplierInfo, HashMap<String, Integer> productInfo) {
        System.out.println("Zamówienie w GlutenFreeShop");

    }
}
