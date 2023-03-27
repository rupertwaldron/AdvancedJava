package com.ruppyrup.patterns.chainofresponsibility.cor;

public class PulseEPP implements EventScope {

    @Override
    public String getScope() {
        return "epp/Pulse";
    }
}
