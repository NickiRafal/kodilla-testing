package com.kodilla.good.patterns.challenges;
import java.util.List;
import java.util.ArrayList;
public class ProductList implements SchowList {
    public List<Product> productList() {
        List<Product> list = new ArrayList<>();
        Product product1 = new Product(1,"Szczoteczka do zębów",4.50,"Szczoteczka elektryczna",10);
        Product product2 = new Product(2,"Nóż kuchenny",10.20,"Nóż ze stali nierdzewnej",10);
        Product product3 = new Product(3,"Krem do twarzy", 8.70,"Krem do cery suchej",10);
        Product product4 = new Product(4,"Monitor komputerowy",1200,"Monitor 21 cali ",5);
        list.add(product1);
        list.add(product2);
        list.add(product3);
        list.add(product4);
        return list;
    }
}
