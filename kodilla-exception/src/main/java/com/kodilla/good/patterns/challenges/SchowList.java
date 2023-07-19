package com.kodilla.good.patterns.challenges;
import java.util.List;

public interface SchowList {
    default String schowListProducts(List<Product> list){
        System.out.println("W naszym sklepie posiadamy " + list.size() + " pozycje ");
        System.out.println();
        int counter = 0;
        for (Product product : list) {
            counter++;
            System.out.println(counter + "  Nazwa:  " + product.getProduct() + product.getIdProduct() + "  Cena:  "
                    + product.getPrice() + " zł   Opis:  " + product.getDescription() + "  Dostępność:  " + product.getQuantity());
            System.out.println("---------------------------");
        }
        return "";
    }

}
