package com.ruppyrup.patterns.pubsub;

public interface Publisher {
    void publish(String message, Broker broker);
}
