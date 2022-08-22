package com.ruppyrup.patterns.observer.unclebob;

public class UncleBobMain {

  public static void main(String[] args) {

  Clock clock = new Clock();
  RealTimeDisplay rtd = new RealTimeDisplay();

  clock.register(rtd);
  }
}
