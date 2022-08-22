package com.ruppyrup.reflection.myrulesengine.engine;

import java.util.function.Function;

public interface Rule<T, R> {
  boolean shouldRun(T input);
  Function<T, R> action();

  int getPriority();

  void setPriority(int priority);

  String getName();
}
