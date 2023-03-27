package com.ruppyrup.patterns.observer.unclebob;

public interface Observer<T> {
  void update(T pusheddata);
}
