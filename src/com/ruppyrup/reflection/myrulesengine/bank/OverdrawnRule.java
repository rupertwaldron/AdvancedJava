package com.ruppyrup.reflection.myrulesengine.bank;

import com.ruppyrup.reflection.myrulesengine.bankengine.AbstractBankRule;

public class OverdrawnRule extends AbstractBankRule<Transaction, RuleAccount> {

  protected OverdrawnRule(int priority, String name) {
    super(priority, name);
  }

  protected OverdrawnRule(String name) {
    super(name);
  }

  @Override
  public boolean shouldRun(Transaction transaction, RuleAccount account) {
    return (transaction.transactionAmount() + account.getBalance()) < account.getOverdraftLimit();
  }

  @Override
  public void action(Transaction transaction, RuleAccount account) {
    LOGGER.info("Withdrawing this amount takes you over your overdraft limit");
  }
}
