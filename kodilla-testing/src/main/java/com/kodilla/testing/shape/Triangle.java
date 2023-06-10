package com.kodilla.testing.shape;

public class Triangle implements Shape {
    private double base;
    private double width;

    public Triangle(double base, double width) {
        this.base = base;
        this.width = width;
    }

    @Override
    public String getShapeName() {
        return "Triangle";
    }

    @Override
    public double getField() {
        return (base * width) /2;
    }
}
