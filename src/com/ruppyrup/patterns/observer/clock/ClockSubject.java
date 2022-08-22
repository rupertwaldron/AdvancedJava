package com.ruppyrup.patterns.observer.clock;

public interface ClockSubject {

   void register(ClockObserver clockObserver);
   void notifyObservers();
}
