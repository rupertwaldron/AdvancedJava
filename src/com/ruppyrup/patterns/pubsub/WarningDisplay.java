package com.ruppyrup.patterns.pubsub;

public class WarningDisplay implements Subscriber {
    private int counter = 0;
    @Override
    public void update(String payload) {
        System.out.println(payload + " is being displayed :: " + counter++);
    }

}
