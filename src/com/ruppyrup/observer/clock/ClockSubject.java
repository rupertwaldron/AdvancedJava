package com.ruppyrup.observer.clock;

public interface ClockSubject {

   void register(ClockObserver clockObserver);
   void notifyObservers();
}
