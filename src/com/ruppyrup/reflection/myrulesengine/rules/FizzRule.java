package com.ruppyrup.reflection.myrulesengine.rules;

import com.ruppyrup.reflection.myrulesengine.engine.AbstractRule;

public class FizzRule extends AbstractRule<Integer> {

  protected FizzRule(int priority, String name) {
    super(priority, name);
  }

  protected FizzRule(String name) {
    super(name);
  }

  @Override
  public boolean shouldRun(Integer input) {
    return input % 5 == 0;
  }

  @Override
  public String action() {
    return "Fizz";
  }
}
