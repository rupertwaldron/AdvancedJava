package com.ruppyrup.patterns.pubsub;

public class Message {
    private Class<?> topic;
    private String payload;

    public Message(){}
    public Message(Class<?> topic, String payload) {
        this.topic = topic;
        this.payload = payload;
    }
    public Class<?> getTopic() {
        return topic;
    }
    public void setTopic(Class<?> topic) {
        this.topic = topic;
    }
    public String getPayload() {
        return payload;
    }
    public void setPayload(String payload) {
        this.payload = payload;
    }
}

