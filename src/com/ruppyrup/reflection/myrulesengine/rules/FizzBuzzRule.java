package com.ruppyrup.reflection.myrulesengine.rules;

import com.ruppyrup.reflection.myrulesengine.engine.AbstractRule;
import java.util.function.Function;

public class FizzBuzzRule extends AbstractRule<Integer, String> {

  protected FizzBuzzRule(int priority, String name) {
    super(priority, name);
  }

  protected FizzBuzzRule(String name) {
    super(name);
  }

  @Override
  public boolean shouldRun(Integer input) {
    return (input % 7 == 0) && (input % 5 == 0);
  }

  @Override
  public Function<Integer, String> action() {
    return a -> "FizzBuzz";
  }
}
