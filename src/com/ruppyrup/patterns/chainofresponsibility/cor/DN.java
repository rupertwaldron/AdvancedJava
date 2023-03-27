package com.ruppyrup.patterns.chainofresponsibility.cor;

public class DN implements EventScope {

    @Override
    public String getScope() {
        return "DN";
    }
}
