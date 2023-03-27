package com.ruppyrup.patterns.bridge.discoverevents.inheritance;

public class PulseSettlement extends Event {
    public PulseSettlement() {
        super(eventScope.PULSE, eventType.SETTLEMENT);
    }

    @Override
    void process() {
        System.out.println("Processing a Pulse settlement event");
    }
}
