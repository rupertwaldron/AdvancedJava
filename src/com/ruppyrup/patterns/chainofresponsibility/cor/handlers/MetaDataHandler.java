package com.ruppyrup.patterns.chainofresponsibility.cor.handlers;


import com.ruppyrup.patterns.chainofresponsibility.cor.Event;

public class MetaDataHandler extends DisEventHandler {
    public MetaDataHandler(DisEventHandler handler) {
        super(handler);
    }

    @Override
    public void handle(Event event) {
        if (event != null && canHandle(event)) {
            System.out.println("MetaData Handler");
            event.setMetaData("Processed with metaData");
        }
        if (handler != null) {
            handler.handle(event);
        }
    }

    private boolean canHandle(Event event) {
        return true;
    }
}
