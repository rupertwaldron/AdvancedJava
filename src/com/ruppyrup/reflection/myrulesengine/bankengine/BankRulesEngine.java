package com.ruppyrup.reflection.myrulesengine.bankengine;

import java.util.function.BiConsumer;

public interface BankRulesEngine<U, V> {

  void addRule(BankRule<U, V> rule);

  void fireUp(U input, V object);

  BiConsumer<U, V> getDefaultAction();

  void setDefaultAction(BiConsumer<U, V> defaultAction);
}
