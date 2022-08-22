package com.ruppyrup.reflection.myrulesengine.fizzbuzz;

import com.ruppyrup.reflection.myrulesengine.engine.AbstractRule;
import java.util.function.Function;

public class FizzRule extends AbstractRule<Integer, String> {

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
  public Function<Integer, String> action() {
    return a -> "Fizz";
  }
}
