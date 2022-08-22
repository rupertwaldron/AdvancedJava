package com.ruppyrup.reflection.myrulesengine.engine;

import java.util.Comparator;

public class RuleComparator implements Comparator<Rule<?, ?>> {

  @Override
  public int compare(Rule<?, ?> rule1, Rule<?, ?> rule2) {
    if (rule1.getPriority() < rule2.getPriority()) {
      return -1;
    } else if (rule1.getPriority() > rule2.getPriority()) {
      return 1;
    } else {
      return rule1.getName().compareTo(rule2.getName());
    }
  }
}
