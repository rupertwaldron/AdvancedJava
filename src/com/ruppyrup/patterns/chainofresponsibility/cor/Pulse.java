package com.ruppyrup.patterns.chainofresponsibility.cor;

public class Pulse implements EventScope {

    @Override
    public String getScope() {
        return "Pulse";
    }
}
