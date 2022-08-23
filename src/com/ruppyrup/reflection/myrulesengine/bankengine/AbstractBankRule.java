package com.ruppyrup.reflection.myrulesengine.bankengine;

import static java.lang.Integer.MAX_VALUE;

import com.ruppyrup.reflection.myrulesengine.bank.Account;
import com.ruppyrup.reflection.myrulesengine.bank.Transaction;
import java.util.logging.Logger;

public abstract class AbstractBankRule<U, V> implements BankRule<U, V> {

  protected static final Logger LOGGER = Logger.getLogger(Account.class.getName());

  private static final int DEFAULT_PRIORITY = MAX_VALUE;

  protected int priority = DEFAULT_PRIORITY;
  protected final String name;

  public AbstractBankRule(int priority, String name) {
    this.priority = priority;
    this.name = name;
  }

  public AbstractBankRule(String name) {
    this.name = name;
  }

  @Override
  public int getPriority() {
    return priority;
  }

  @Override
  public void setPriority(int priority) {
    this.priority = priority;
  }

  @Override
  public String getName() {
    return name;
  }

  public abstract boolean shouldRun(U input, V object);

  public abstract void action(Transaction transaction, Account account);
}
