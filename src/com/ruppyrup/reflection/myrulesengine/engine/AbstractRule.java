package com.ruppyrup.reflection.myrulesengine.engine;

import static java.lang.Integer.MAX_VALUE;

public abstract class AbstractRule<T, R> implements Rule<T, R> {

  private static final int DEFAULT_PRIORITY = MAX_VALUE;

  protected int priority = DEFAULT_PRIORITY;
  protected final String name;

  public AbstractRule(int priority, String name) {
    this.priority = priority;
    this.name = name;
  }

  public AbstractRule(String name) {
    this.name = name;
  }

  @Override
  public int getPriority() {
    return priority;
  }

  @Override
  public void setPriority(int priority) {
    this.priority = priority;
  }

  @Override
  public String getName() {
    return name;
  }

}
