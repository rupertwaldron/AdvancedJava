package com.ruppyrup.patterns.pubsub;

public class Radar implements Publisher {
    @Override
    public void publish(String payload, Broker broker) {
        try {
            Thread.sleep((long) (100 * Math.random()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        broker.sendMessage(new Message(this.getClass(), payload));
    }
}
