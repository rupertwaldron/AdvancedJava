package com.ruppyrup.reflection.myrulesengine.fizzbuzz;

import com.ruppyrup.reflection.myrulesengine.engine.AbstractRule;
import java.util.function.Function;

public class BuzzRule extends AbstractRule<Integer, String> {

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
  public Function<Integer, String> action() {
    return a -> "Buzz";
  }
}
