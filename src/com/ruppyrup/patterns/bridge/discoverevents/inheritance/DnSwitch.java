package com.ruppyrup.patterns.bridge.discoverevents.inheritance;

public class DnSwitch extends Event {
    public DnSwitch() {
        super(eventScope.DN, eventType.SWITCH);
    }

    @Override
    void process() {
        System.out.println("Processing a DN switch event");
    }
}
