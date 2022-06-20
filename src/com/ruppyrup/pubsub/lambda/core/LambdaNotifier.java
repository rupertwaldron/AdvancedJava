package com.ruppyrup.pubsub.lambda.core;

import com.ruppyrup.pubsub.lambda.utils.UtilLock;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class LambdaNotifier implements Notifier {

  private final ConcurrentMap<Class<?>, Set<Consumer<?>>> eventMap = new ConcurrentHashMap<>();

  private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
  private final Lock readLock = lock.readLock();
  private final Lock writeLock = lock.writeLock();

  @Override
  public <T> void publish(Class<T> identifier, Supplier<T> notificationSupplier) {
    final Set<Consumer<?>> notificationEvents = new HashSet<>();
    UtilLock.lock(readLock, () -> {
      final Collection<Consumer<?>> item = eventMap.get(identifier);
      if (item != null) {
        notificationEvents.addAll(item);
      }
    });

    notificationEvents.stream()
        .map(c -> (Consumer<T>) c)
        .forEach(consumer -> consumer.accept(notificationSupplier.get()));
  }

  @Override
  public <T> void subscribe(Class<T> identifier, Consumer<T> notificationConsumer) {
    UtilLock.lock(writeLock, () -> {
      if (eventMap.containsKey(identifier)) {
        eventMap.get(identifier).add(notificationConsumer);
      } else {
        final Set<Consumer<?>> eventSet = new HashSet<>();
        eventSet.add(notificationConsumer);
        eventMap.put(identifier, eventSet);
      }

    });
  }
}
