package com.ruppyrup.pubsub;

public class MissileDetect implements Publisher {
    @Override
    public void publish(String payload, Broker broker) {
        broker.sendMessage(new Message(this.getClass(), payload));
    }
}
