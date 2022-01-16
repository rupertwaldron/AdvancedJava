package com.ruppyrup.pubsub;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

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

    private final Map<Class<?>, Set<Subscriber>> subscribers = new ConcurrentHashMap<>();

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
            final Set<Subscriber> sub = this.subscribers.get(message.getTopic());
            sub.parallelStream().forEach(subscriber -> subscriber.update(message.getPayload()));
        }
    }

}
