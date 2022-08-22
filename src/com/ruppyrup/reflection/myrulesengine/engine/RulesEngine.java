package com.ruppyrup.reflection.myrulesengine.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;

public class RulesEngine<T, R> {
  private final List<Rule<T, R>> rules = new ArrayList<>();

  private Function<T, R> defaultAction;

  public RulesEngine(Function<T, R> defaultAction) {
    this.defaultAction = defaultAction;
  }

  private final Set<Rule<T, R>> rulesToApply= new TreeSet<>(new RuleComparator());;

  public void addRule(Rule<T, R> rule) {
    rules.add(rule);
  }

  public R fireUp(T input) {
    createSetOfApplicableRules(input);
    R result = null;

    if (rulesToApply.isEmpty()) {
      result = defaultAction.apply(input);
    } else {
      for (Rule<T, R> rule : rulesToApply) {
        result = rule.action().apply(input);
      }
    }
    return result;
  }

  private void createSetOfApplicableRules(T input) {
    rulesToApply.clear();
    for (Rule<T, R> rule : rules) {
      if (rule.shouldRun(input))
          rulesToApply.add(rule);
    }
  }

  public Function<T, R> getDefaultAction() {
    return defaultAction;
  }

  public void setDefaultAction(Function<T, R> defaultAction) {
    this.defaultAction = defaultAction;
  }
}
