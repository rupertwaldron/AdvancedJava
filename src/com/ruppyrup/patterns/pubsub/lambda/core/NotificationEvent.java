package com.ruppyrup.patterns.pubsub.lambda.core;

@FunctionalInterface
public interface NotificationEvent<T> {

  void receiveData(T data);

  @SuppressWarnings("unchecked")
  default void receiveNotificationObjectData(final Object data) {
    receiveData((T) data);
  }

}
