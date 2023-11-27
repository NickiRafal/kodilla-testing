package com.kodilla.patterns2.decorator.pizza;

public class HamDecorator implements Pizza {
    private final Pizza pizza;

    public HamDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 4.0;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", szynka";
    }
}
