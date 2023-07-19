package com.kodilla.good.patterns.challenges;
import java.util.Objects;

public class Product {
    private final int idProduct;
    private final String product;
    private final double price;
    private final String description;
    private final int quantity;

    public Product(int idProduct, String product, double price, String description, int quantity) {
        this.idProduct = idProduct;
        this.product = product;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
    }
    public int getIdProduct() {
        return idProduct;
    }

    public String getProduct() {
        return product;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product1 = (Product) o;
        return idProduct == product1.idProduct && Double.compare(product1.price, price) == 0 && quantity == product1.quantity && Objects.equals(product, product1.product) && Objects.equals(description, product1.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProduct, product, price, description, quantity);
    }

    @Override
    public String toString() {
        return "Product{" +
                "idProduct=" + idProduct +
                ", product='" + product + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
