package com.ruppyrup.pubsub;

public interface Publisher {
    void publish(String message, Broker broker);
}
