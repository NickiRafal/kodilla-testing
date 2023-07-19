package com.kodilla.good.patterns.challenges;
public class ProductOrderService {
    private final Basket basket;
    private final OrdersRepository ordersRepository;
    private final ProductList productList;

    public ProductOrderService(final Basket basket,final OrdersRepository ordersRepository,final ProductList productList) {

        this.basket = basket;
        this.ordersRepository = ordersRepository;
        this.productList = productList;
    }

    public Basket getBasket() {
        return basket;
    }

    public OrdersRepository getOrdersRepository() {
        return ordersRepository;
    }

    public ProductList getProductList() {
        return productList;
    }

}
