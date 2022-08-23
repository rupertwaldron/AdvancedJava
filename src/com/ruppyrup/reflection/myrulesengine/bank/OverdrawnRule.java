package com.ruppyrup.reflection.myrulesengine.bank;

import com.ruppyrup.reflection.myrulesengine.bankengine.AbstractBankRule;

public class OverdrawnRule extends AbstractBankRule<Transaction, Account> {

  protected OverdrawnRule(int priority, String name) {
    super(priority, name);
  }

  protected OverdrawnRule(String name) {
    super(name);
  }

  @Override
  public boolean shouldRun(Transaction transaction, Account account) {
    return (transaction.transactionAmount() + account.getBalance()) < account.getOverdraftLimit();
  }

  @Override
  public void action(Transaction transaction, Account account) {
    LOGGER.info("Withdrawing this amount takes you over your overdraft limit");
  }
}
