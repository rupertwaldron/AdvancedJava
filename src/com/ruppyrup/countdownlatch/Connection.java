package com.ruppyrup.countdownlatch;

public enum Connection {
    INSTANCE;

    private int counter;

 synchronized int getCounter() {
    return counter;
  }

  synchronized void incrementCounter() {
    counter++;
  }
}
