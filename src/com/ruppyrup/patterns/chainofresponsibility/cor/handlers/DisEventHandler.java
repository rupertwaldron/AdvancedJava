package com.ruppyrup.patterns.chainofresponsibility.cor.handlers;

import com.ruppyrup.patterns.chainofresponsibility.cor.Event;

public abstract class DisEventHandler {
    protected DisEventHandler handler;

    protected DisEventHandler(DisEventHandler handler) {
        this.handler = handler;
    }

    public abstract void handle(Event event);
}
