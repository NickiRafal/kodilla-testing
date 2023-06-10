package com.kodilla.testing.shape;


import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {
    private List<Shape> shapes;

    public ShapeCollector() {
        shapes = new ArrayList<>();
    }

    public void addFigure(Shape shape) {
        shapes.add(shape);
    }

    public boolean removeFigure(Shape shape) {
        return shapes.remove(shape);
    }

    public Shape getFigure(int n) {
        if (n >= 0 && n < shapes.size()) {
            return shapes.get(n);
        }
        return null;
    }
    public int getFiguresCount() {
        return shapes.size();
    }

    public void showFigures() {
        for (Shape shape : shapes) {
            System.out.println("Shape: " + shape.getShapeName());
            System.out.println("Field: " + shape.getField());
            System.out.println("--------------------");
        }
    }


}
