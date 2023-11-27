package com.kodilla.patterns2.decorator.pizza;

public class BasicPizza implements Pizza{
    @Override
    public double getCost() {
        return 15.0;
    }

    @Override
    public String getDescription() {
        return "Ciasto i sos pomidorowy z serem";
    }
}
