package com.kodilla.good.patterns.challenges;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Basket implements SchowList {
    public List<Product> addToBasket(List<Product> products) {
        Scanner scanner = new Scanner(System.in);
        List<Product> cart = new ArrayList<>();
        System.out.println("Dodawanie produktów do koszyka. Podaj numer produktu lub pisz 'x' aby zakończyć.");
        String imput;
        System.out.print("Podaj identyfikator produktu: ");
        while (!(imput = scanner.nextLine()).equalsIgnoreCase("x")) {
            try {
                boolean found = false;
                int id = Integer.parseInt(imput);
                for (Product product : products) {
                    if (product.getIdProduct() == id) {
                        cart.add(product);
                        found = true;
                        System.out.println("Produkt dodany do koszyka to:  " + product.getProduct() +
                                "  " + product.getDescription());

                        System.out.println("Podaj identyfikator produktu: ");
                        break;
                    }
                }if (!found) {
                    System.out.println("Produkt o podanym identyfikatorze nie istnieje. Spróbuj ponownie.\n");
                }
            }catch (NumberFormatException e){
                System.out.println("Wprowadzony identyfikator jest nie poprawny");
            }
        }
        System.out.println("Zakończyłeś dodawanie do koszyka");

        return cart;
    }

    @Override
    public String schowListProducts(List<Product> list) {
        for (Product basketList : list) {
            System.out.println("Dodałeś do koszyka " + basketList.getProduct() + "  " + basketList.getDescription());
        }
        return "";
    }
}
