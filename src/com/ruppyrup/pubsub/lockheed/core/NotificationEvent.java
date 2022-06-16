package com.ruppyrup.pubsub.lockheed.core;

@FunctionalInterface
public interface NotificationEvent<T> {

  void receiveData(T data);

  @SuppressWarnings("unchecked")
  default void receiveNotificationObjectData(final Object data) {
    receiveData((T) data);
  }

}
