package com.ruppyrup.patterns.observer.clock;

import java.util.ArrayList;
import java.util.List;

public class ObservableClock extends Clock implements ClockSubject {

  private final List<ClockObserver> clockObservers = new ArrayList<>();

  @Override
  protected void updateTime() {
    super.updateTime();
    System.out.println("Calling observableclock updateTime");
    notifyObservers();
  }

  @Override
  public void register(ClockObserver clockObserver) {
    clockObservers.add(clockObserver);
  }

  @Override
  public void notifyObservers() {
    clockObservers.forEach(ClockObserver::update);
  }

}
