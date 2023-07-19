package com.kodilla.good.patterns.challenges;
import com.kodilla.good.patterns.challenges.Product;
import java.util.List;

public interface SchowBasket {
    default String schowBasket(List<Product> baskets) {
        for (Product basketList : baskets) {
            System.out.println("Dodałeś do koszyka " + basketList.getProduct() + "  " + basketList.getDescription());
        }
        return "";
    }
}
