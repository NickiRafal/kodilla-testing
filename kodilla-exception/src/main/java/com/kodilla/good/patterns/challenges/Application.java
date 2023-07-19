package com.kodilla.good.patterns.challenges;
import java.util.List;
public class Application {
    public static void main(String[] args) {
        ProductList productList = new ProductList();
        Basket basket = new Basket();
        OrdersRepository ordersRepository = new OrdersRepository();
        ProductOrderService productOrderService = new ProductOrderService(basket,ordersRepository,productList);

        String productInfo = productOrderService.getProductList().schowListProducts(productList.productList());
        System.out.println(productInfo);

        List<Product> baskets = productOrderService.getBasket().addToBasket(productList.productList());
        String basketInfo = productOrderService.getBasket().schowBasket(baskets);
        System.out.println(basketInfo);

        List<Product> saveRepo = productOrderService.getOrdersRepository().saveOrder(baskets);
        String saveRepoInfo = productOrderService.getOrdersRepository().schowRepo(saveRepo);
        System.out.println(saveRepoInfo);
    }
}
