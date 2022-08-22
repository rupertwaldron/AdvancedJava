package com.ruppyrup.reflection.myrulesengine.bankengine;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BiConsumer;

public class DefaultBankRulesEngine<U, V> implements BankRulesEngine<U, V> {
  private final List<BankRule<U, V>> rules = new ArrayList<>();

  private BiConsumer<U, V> defaultAction;

  public DefaultBankRulesEngine(BiConsumer<U, V> defaultAction) {
    this.defaultAction = defaultAction;
  }

  private final Set<BankRule<U, V>> rulesToApply= new TreeSet<>(new BankRuleComparator());;

  @Override
  public void addRule(BankRule<U, V> rule) {
    rules.add(rule);
  }

  @Override
  public void fireUp(U input, V object) {
    createSetOfApplicableRules(input, object);

    if (rulesToApply.isEmpty()) {
      defaultAction.accept(input, object);
    } else {
      for (BankRule<U, V> rule : rulesToApply) {
        rule.action(input, object);
      }
    }
  }

  private void createSetOfApplicableRules(U input, V object) {
    rulesToApply.clear();
    for (BankRule<U, V> rule : rules) {
      if (rule.shouldRun(input, object))
          rulesToApply.add(rule);
    }
  }

  @Override
  public BiConsumer<U, V> getDefaultAction() {
    return defaultAction;
  }

  @Override
  public void setDefaultAction(BiConsumer<U, V> defaultAction) {
    this.defaultAction = defaultAction;
  }
}
