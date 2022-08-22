package com.ruppyrup.patterns.visitor;

public interface Visitor {

    void visit(Circle o);

    void visit(Square o);
}
