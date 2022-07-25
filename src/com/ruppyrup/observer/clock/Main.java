package com.ruppyrup.observer.clock;

public class Main {

  public static void main(String[] args) throws InterruptedException {
    ObservableClock clock = new ObservableClock();
    RealTimeDisplay rtd = new RealTimeDisplay(clock);


  }

}
