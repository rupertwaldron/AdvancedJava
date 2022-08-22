package com.ruppyrup.reflection.myrulesengine.bankengine;

public interface BankRule<U, V> {
  boolean shouldRun(U input, V object);

  void action(U input, V object);

  int getPriority();

  void setPriority(int priority);

  String getName();
}
