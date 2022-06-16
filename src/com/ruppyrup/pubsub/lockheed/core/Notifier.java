package com.ruppyrup.pubsub.lockheed.core;

import java.util.function.Consumer;
import java.util.function.Supplier;

public interface Notifier {

  <T> void publish(Class<T> clazz, Supplier<T> notificationSupplier);

  <T> void subscribe(Class<T> identifier, Consumer<T> notificationConsumer);

}
