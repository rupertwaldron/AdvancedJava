package com.ruppyrup.patterns.chainofresponsibility.cor;

public class Switch implements EventType {
    @Override
    public String getType() {
        return "Switch";
    }
}
