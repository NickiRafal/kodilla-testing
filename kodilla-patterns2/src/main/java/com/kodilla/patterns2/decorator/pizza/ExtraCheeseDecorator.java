package com.kodilla.patterns2.decorator.pizza;

public class ExtraCheeseDecorator implements Pizza {
    private final Pizza pizza;

    public ExtraCheeseDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 2.0;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", dodatkowy ser";
    }
}
