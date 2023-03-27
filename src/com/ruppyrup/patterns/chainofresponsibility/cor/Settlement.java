package com.ruppyrup.patterns.chainofresponsibility.cor;

public class Settlement implements EventType {
    @Override
    public String getType() {
        return "Settlement";
    }
}
