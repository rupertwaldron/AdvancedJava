package com.ruppyrup.visitor;

public class VisitorTest {
    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape square = new Square();
        Visitor htmlVisitor = new HtmlVisitor();

        circle.accept(htmlVisitor);
        square.accept(htmlVisitor);
    }
}
