package com.kodilla.good.patterns.challenges;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OrdersRepository implements SchowRepository{
    public List <Product>saveOrder(List <Product> products) {
        List<Product> shoppingList = new ArrayList<>();
        for (Product product : products) {
            shoppingList.add(product);
        }
        String fileName = "Zamowienie.txt";
        if (products.size() != 0) {
            try {
                File file = new File(fileName);
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileWriter fileWriter = new FileWriter(file);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write(shoppingList.toString());
                bufferedWriter.close();
                fileWriter.close();
                System.out.println("Twoje zamówienie zostało zapisane");
            } catch (IOException e) {
                System.out.println("Wystąpił błąd podczas zapisywania pliku");
            }
            System.out.println("Produkty które zamówiłeś to  ");
        }
        return shoppingList;
    }
}
