package com.ruppyrup.patterns.observer.clock;

public class RealTimeDisplay implements ClockObserver {

  private final ObservableClock clock;


  public RealTimeDisplay(ObservableClock clock) {
    this.clock = clock;
    clock.register(this);
  }

  public void showTime() {
      System.out.println("Time = " + clock.getTime());
  }

  @Override
  public void update() {
    showTime();
  }
}

