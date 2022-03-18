package com.ruppyrup.visitor;


public interface Shape {
    void draw();
    void accept(Visitor visitor);
}
