package com.kodilla.testing.shape;



public class Main {
    public static void main(String[] args) {
        ShapeCollector shapeCollector = new ShapeCollector();

        Circle circle = new Circle(5);
        Rectangle rectangle = new Rectangle(3, 4);
        Triangle triangle = new Triangle(4,5);

        shapeCollector.addFigure(circle);
        shapeCollector.addFigure(rectangle);
        shapeCollector.addFigure(triangle);

        shapeCollector.showFigures();
    }
}