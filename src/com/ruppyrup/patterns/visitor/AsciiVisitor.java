package com.ruppyrup.patterns.visitor;

public class AsciiVisitor implements Visitor {

    public void visit(Circle o) {
        String circle = """
            ****************
            I am a circle\n
            ***************
                """ + o.toString();
        System.out.println(circle);
    }

    public void visit(Square o) {
        String square = """
              ***************
              I am a square\n
              ***************
                """ + o.toString();
        System.out.println(square);
    }
}
