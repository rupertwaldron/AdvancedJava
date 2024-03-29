package com.ruppyrup.reflection.myrulesengine.bank;

import java.util.logging.Logger;

public class RuleAccount implements Account {

  private static final Logger LOGGER = Logger.getLogger(RuleAccount.class.getName());
  private final String name;
  private double balance;
  private boolean suspended = false;
  private double overdraftLimit = -100.0;

  public RuleAccount(String name) {
    this.name = name;
  }

  @Override
  public void processTransaction(Transaction transaction) {
    balance += transaction.transactionAmount();
  }

  @Override
  public double getBalance() {
    return balance;
  }

  @Override
  public void suspendAccount() {
    suspended = true;
  }

  @Override
  public void unsuspendAccount() {
    suspended = false;
  }

  @Override
  public boolean isSuspended() {
    return suspended;
  }

  @Override
  public double getOverdraftLimit() {
    return overdraftLimit;
  }

  @Override
  public void setOverdraftLimit(double overdraftLimit) {
    this.overdraftLimit = overdraftLimit;
  }

  @Override
  public void printBalance() {
    System.out.println("Balance for account: " + name + " = " + balance);
  }
}
