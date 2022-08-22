package com.ruppyrup.reflection.myrulesengine.rules;

import com.ruppyrup.reflection.myrulesengine.engine.AbstractRule;

public class BuzzRule extends AbstractRule<Integer> {

  protected BuzzRule(int priority, String name) {
    super(priority, name);
  }

  protected BuzzRule(String name) {
    super(name);
  }

  @Override
  public boolean shouldRun(Integer input) {
    return input % 7 == 0;
  }

  @Override
  public String action() {
    return "Buzz";
  }
}
