package com.ruppyrup.reflection.myrulesengine.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class RulesEngine<T> {
  private final List<Rule<T>> rules = new ArrayList<>();

  private final Set<Rule<T>> rulesToApply= new TreeSet<>(new RuleComparator());;

  public void addRule(Rule<T> rule) {
    rules.add(rule);
  }

  public void fireUp(T input) {
    rulesToApply.clear();
    for (Rule<T> rule : rules) {
      if (rule.shouldRun(input))
          rulesToApply.add(rule);
    }

    if (rulesToApply.isEmpty()) {
      System.out.println(input);
    } else {
      String result = "";
      for (Rule<T> rule : rulesToApply) {
        result = rule.action();
      }
      System.out.println(result);
    }
  }
}
