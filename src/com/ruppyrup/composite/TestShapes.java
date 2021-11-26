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

        Display display = new ScreenDisplay();

        circle1.draw(display);

        System.out.println("*****************");

        group.draw(display);

        System.out.println("*****************");

        Display starDisplay = new StarDisplay();

        group.draw(starDisplay);



    }
}

interface Display {
    void display(Shape shape);
}

class ScreenDisplay implements Display {

    public void display(Shape shape) {
        System.out.println("Drawing a " + shape.getColor() + " " + shape.getName() + ".");
    }
}

class StarDisplay implements Display {

    public void display(Shape shape) {
        System.out.println("*************************************");
        System.out.print("***");
        System.out.print("Drawing a " + shape.getColor() + " " + shape.getName() + ".");
        System.out.println("***");
        System.out.println("*************************************");
    }
}
