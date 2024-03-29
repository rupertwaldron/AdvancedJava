package com.ruppyrup.patterns.observer.unclebob;

import java.time.LocalTime;

public class RealTimeDisplay implements Observer<LocalTime> {
  public RealTimeDisplay() {
  }

  public void showTime(LocalTime time) {
      System.out.println("Time = " + time);
  }

  @Override
  public void update(LocalTime data) {
    showTime(data);
  }
}

