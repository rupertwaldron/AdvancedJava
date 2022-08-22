package com.ruppyrup.reflection.myrulesengine.bank;

import com.ruppyrup.reflection.myrulesengine.bankengine.AbstractBankRule;

public class SuspendedRule extends AbstractBankRule<Transaction, RuleAccount> {

  protected SuspendedRule(int priority, String name) {
    super(priority, name);
  }

  protected SuspendedRule(String name) {
    super(name);
  }

  @Override
  public boolean shouldRun(Transaction transaction, RuleAccount account) {
    return account.isSuspended();
  }

  @Override
  public void action(Transaction transaction, RuleAccount account) {
    LOGGER.info("Your account is suspended" );
  }
}
