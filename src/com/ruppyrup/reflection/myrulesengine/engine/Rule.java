package com.ruppyrup.reflection.myrulesengine.engine;

public interface Rule<T> {
  boolean shouldRun(T input);
  String action();

  int getPriority();

  void setPriority(int priority);

  String getName();
}
