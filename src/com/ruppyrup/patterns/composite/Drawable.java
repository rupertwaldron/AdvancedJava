package com.ruppyrup.patterns.composite;

import java.util.ArrayList;
import java.util.List;

public interface Drawable {
    void draw(Display display);
}

abstract class Shape implements Drawable {
    private String color;
    private String name;

    protected Shape() {}

    protected Shape(String color, String name) {
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

    public String getInfo() {
        return "Drawing a " + getColor() + " " + getName() + ".";
    }

    @Override
    public void draw(Display display) {
        display.display(this);
    }
}

class Circle extends Shape {

    public Circle(String color) {
        super(color, "Circle");
    }

}

class Square extends Shape {

    public Square(String color) {
        super(color, "Square");
    }


}

class ShapeGroup extends Shape {
    private final List<Drawable> shapes = new ArrayList<>();

    public void add(Drawable s) {
        shapes.add(s);
    }

    @Override
    public void draw(Display display) {
        shapes.forEach(shape -> shape.draw(display));
    }
}
