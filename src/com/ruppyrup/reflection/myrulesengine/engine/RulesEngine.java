package com.ruppyrup.reflection.myrulesengine.engine;

import java.util.function.Function;

public interface RulesEngine<T, R> {

  void addRule(Rule<T, R> rule);

  R fireUp(T input);

  Function<T, R> getDefaultAction();

  void setDefaultAction(Function<T, R> defaultAction);
}
