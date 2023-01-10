package com.ruppyrup.threads.semaphores;

public class ResourceUnit {
  private final int id;

  private int counter;

  public ResourceUnit(int id) {
    this.id = id;
  }

  public int getCounter() {
    return counter;
  }

  public void incrementCounter() {
    safeSleep();
    counter++;
  }

  private static void safeSleep() {
    try {
      Thread.sleep((long) (Math.random() * 5));
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  public int getId() {
    return id;
  }

  public boolean isFinished() {
    safeSleep();
    return counter == 100;
  }
}
