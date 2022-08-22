package com.ruppyrup.patterns.pubsub;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class Broker {
    private final Object mutex = new Object();

    private static Broker brokerInstance;

    private Broker() {}

    public static Broker getInstance() {
        if (null == brokerInstance) {
            brokerInstance = new Broker();
        }
        return brokerInstance;
    }

    private final Map<Class<?>, Set<Subscriber>> subscribers = new HashMap<>();

    public boolean deregister(Class<?> topic, Subscriber subscriber) {
        synchronized (mutex) {
            final Set<Subscriber> subs = this.subscribers.get(topic);
            return subs.remove(subscriber);
        }
    }

    public void register(Class<?> topic, Subscriber subscriber) {
        synchronized (mutex) {
            if (subscribers.containsKey(topic)) {
                subscribers.get(topic).add(subscriber);
            } else {
                Set<Subscriber> sub = new HashSet<>();
                sub.add(subscriber);
                subscribers.put(topic, sub);
            }
        }
    }

    public void sendMessage(Message message) {
        synchronized (mutex) {
            subscribers.get(message.getTopic())
                    .forEach(subscriber -> subscriber.update(message.getPayload()));
//            sub.parallelStream().forEach(subscriber -> subscriber.update(message.getPayload()));
        }
    }

}
