package com.ruppyrup.observer.unclebob;

public interface Observer<T> {
  void update(T data);
}
