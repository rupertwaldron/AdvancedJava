package com.ruppyrup.visitor;

public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing square");
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "Square{}";
    }
}
