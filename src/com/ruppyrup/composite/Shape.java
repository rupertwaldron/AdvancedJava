package com.ruppyrup.composite;

import java.util.ArrayList;
import java.util.List;

public interface Shape {
    void draw();
}

abstract class AbstractShape implements Shape {
    private String color;
    private String name;

    protected AbstractShape(String color, String name) {
        this.color = color;
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Circle extends AbstractShape {

    public Circle(String color) {
        super(color, "Circle");
    }

    @Override
    public void draw() {
        System.out.println("Drawing a " + getColor() + " " + getName() + ".");
    }
}

class Square extends AbstractShape {

    public Square(String color) {
        super(color, "Square");
    }

    @Override
    public void draw() {
        System.out.println("Drawing a " + getColor() + " " + getName() + ".");
    }
}

class ShapeGroup implements Shape {
    private final List<Shape> shapes = new ArrayList<>();

    public void add(Shape s) {
        shapes.add(s);
    }

    public void draw() {
        shapes.forEach(Shape::draw);
    }
}
