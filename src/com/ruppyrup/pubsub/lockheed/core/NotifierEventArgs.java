package com.ruppyrup.pubsub.lockheed.core;

public class NotifierEventArgs {

  private final Class<?> identifier;
  private final NotificationEvent<?> notificationEvent;

  public NotifierEventArgs(Class<?> identifier, NotificationEvent<?> notificationEvent) {
    this.identifier = identifier;
    this.notificationEvent = notificationEvent;
  }

  public Class<?> getIdentifier() {
    return identifier;
  }
}
