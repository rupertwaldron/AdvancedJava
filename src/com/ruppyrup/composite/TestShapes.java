package com.ruppyrup.composite;

public class TestShapes {
    public static void main(String[] args) {
        Shape circle = new Circle("red");
        Shape square = new Square("green");
        Shape circle1 = new Circle("pink");
        Shape square1 = new Square("yellow");
        ShapeGroup group = new ShapeGroup();

        group.add(circle);
        group.add(square);

        Display display = new Display();
        display.loadShapes(circle1);
        display.loadShapes(square1);
        display.loadShapes(group);

        display.display();
    }
}

class Display {
    private ShapeGroup allShapes = new ShapeGroup();

    public void loadShapes(Shape shape) {
        allShapes.add(shape);
    }

    public void display() {
        allShapes.draw();
    }
}
