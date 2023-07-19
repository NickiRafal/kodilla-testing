package com.kodilla.good.patterns.management;
import java.util.HashMap;
public class Food2Door {
    public static void main(String[] args) {
        ExtraFoodShop extraFoodShop = new ExtraFoodShop();
        HashMap<String,Integer> order1 = new HashMap<>();
        order1.put("Jabłko",5);
        order1.put("Banan",3);
        extraFoodShop.process("ExtraFoodSupplier",order1);

        HealthyShop healthyShop = new HealthyShop();
        HashMap<String,Integer> order2 = new HashMap<>();
        order2.put("Brokuły",5);
        order2.put("Marchewka",4);
        healthyShop.process("HealthySupplier",order2);

        GlutenFreeShop glutenFreeShop = new GlutenFreeShop();
        HashMap<String,Integer> order3 = new HashMap<>();
        order3.put("Chleb bezglutenowy",8);
        order3.put("Mleko kokosowe",4);
        glutenFreeShop.process("GlutenFreeSupplier",order3);

    }
}