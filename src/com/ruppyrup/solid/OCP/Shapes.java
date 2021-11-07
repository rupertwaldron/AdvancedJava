package com.ruppyrup.solid.OCP;

import java.util.ArrayList;
import java.util.List;

interface Shape {
    void draw();
    void apply(Filter filter);
}

class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Drawing circle");
    }

    @Override
    public void apply(Filter filter) {
        filter.applyTo(this);
    }
}

class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Drawing square");
    }

    @Override
    public void apply(Filter filter) {
        filter.applyTo(this);
    }
}

@FunctionalInterface
interface Filter {
    void applyTo(Shape shape);
}

public class Shapes implements Shape {
    private List<Shape> shapes = new ArrayList<>();



    public void add(Shape shape) {
        shapes.add(shape);
    }

    @Override
    public void draw() {
        shapes.forEach(Shape::draw);
    }

    @Override
    public void apply(Filter filter) {
        shapes.forEach(s -> s.apply(filter));
    }

    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape square = new Square();
        Shapes shapes = new Shapes();
        shapes.add(circle);
        shapes.add(square);

        shapes.draw();

        shapes.apply(s -> System.out.println(s.getClass().getSimpleName() + " has been filtered"));

        CheckShape.getShape(circle);
        CheckShape.getShape(shapes);


    }
}

class CheckShape {
    public static Shape getShape(Shape shape) {
        shape.draw();
        return new Shapes();
    }
}
