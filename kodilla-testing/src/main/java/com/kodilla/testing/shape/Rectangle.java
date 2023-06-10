package com.kodilla.testing.shape;



public class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public String getShapeName() {
        return "Rectangle";
    }

    @Override
    public double getField() {
        return width * height;
    }
}

