package com.ruppyrup.patterns.chainofresponsibility.cor.handlers;


import com.ruppyrup.patterns.chainofresponsibility.cor.Event;
import com.ruppyrup.patterns.chainofresponsibility.cor.PulseEPP;

public class PulseNameHandler extends DisEventHandler {
    public PulseNameHandler(DisEventHandler handler) {
        super(handler);
    }

    @Override
    public void handle(Event event) {
        if (event != null && canHandle(event)) {
            System.out.println("Pulse Name Handler");
            event.setEventScope(new PulseEPP());
        }
        if (handler != null) {
            handler.handle(event);
        }
    }

    private boolean canHandle(Event event) {
        return "Pulse".equals(event.getEventScope());
    }
}
