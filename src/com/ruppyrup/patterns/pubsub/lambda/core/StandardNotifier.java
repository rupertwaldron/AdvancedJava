package com.ruppyrup.patterns.pubsub.lambda.core;

import com.ruppyrup.patterns.pubsub.lambda.utils.UtilLock;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class StandardNotifier implements Notifier {

  private final ConcurrentMap<Class<?>, Set<NotificationEvent<?>>> eventMap = new ConcurrentHashMap<>();

  private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
  private final Lock readLock = lock.readLock();
  private final Lock writeLock = lock.writeLock();

  @Override
  public <T> void publish(Class<T> identifier, Supplier<T> notificationSupplier) {
    publishTo(identifier, new NotificationObject<>(notificationSupplier.get()));
  }

  private <T> void publishTo(Class<T> identifier, NotificationObject<?> data) {
    final Set<NotificationEvent<?>> notificationEvents = new HashSet<>();
    UtilLock.lock(readLock, () -> {
      final Collection<NotificationEvent<?>> item = eventMap.get(identifier);
      if (item != null)
        notificationEvents.addAll(item);
    });

    for (final NotificationEvent<?> notificationEvent : notificationEvents)
      notificationEvent.receiveNotificationObjectData(data.data());
  }

  @Override
  public <T> void subscribe(Class<T> identifier, Consumer<T> notificationConsumer) {
    subscribeTo(identifier, (NotificationEvent<T>) notificationConsumer::accept);
  }

  private void subscribeTo(Class<?> identifier, NotificationEvent<?> notificationEvent) {

    UtilLock.lock(writeLock, () -> {
      if (eventMap.containsKey(identifier))
        eventMap.get(identifier).add(notificationEvent);
      else {
        final Set<NotificationEvent<?>> eventSet = new HashSet<>();
        eventSet.add(notificationEvent);
        eventMap.put(identifier, eventSet);
      }

    });

  }
}
