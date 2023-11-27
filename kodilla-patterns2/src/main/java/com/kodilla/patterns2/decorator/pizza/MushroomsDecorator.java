package com.kodilla.patterns2.decorator.pizza;

public class MushroomsDecorator implements Pizza {
    private final Pizza pizza;

    public MushroomsDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 3.0;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", pieczarki";
    }
}