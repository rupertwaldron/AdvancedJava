package com.ruppyrup.reflection.myrulesengine.bankengine;

import java.util.Comparator;

public class BankRuleComparator implements Comparator<BankRule<?, ?>> {

  @Override
  public int compare(BankRule<?, ?> rule1, BankRule<?, ?> rule2) {
    if (rule1.getPriority() < rule2.getPriority()) {
      return -1;
    } else if (rule1.getPriority() > rule2.getPriority()) {
      return 1;
    } else {
      return rule1.getName().compareTo(rule2.getName());
    }
  }
}
