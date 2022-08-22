package com.ruppyrup.patterns.visitor;

public class HtmlVisitor implements Visitor {

    public void visit(Circle o) {
        String circle = """
              <p>I am a circle<p>\n
                """ + o.toString();
        System.out.println(circle);
    }

    public void visit(Square o) {
        String square = """
              <p>I am a square<p>\n
                """ + o.toString();
        System.out.println(square);
    }
}
