package com.ruppyrup.pubsub.lockheed.core;

import java.util.UUID;

public abstract class Plugin {

  private final UUID identifier;
  private String description;
  private String name;
  private Notifier manager;


  protected Plugin(UUID identifier) {
    this.identifier = identifier;
  }

  public Notifier getNotifier() {
    return manager;
  }

  public void setNotifier(Notifier manager) {
    this.manager = manager;
  }

  public abstract void shutdown();

  public abstract void start();
}
