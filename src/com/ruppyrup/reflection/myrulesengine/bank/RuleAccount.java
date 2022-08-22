package com.ruppyrup.reflection.myrulesengine.bank;

import java.util.logging.Logger;

public class RuleAccount {

  private static final Logger LOGGER = Logger.getLogger(RuleAccount.class.getName());
  private final String name;
  private double balance;
  private boolean suspended = false;
  private double overdraftLimit = -100.0;

  public RuleAccount(String name) {
    this.name = name;
  }

  public void processTransaction(Transaction transaction) {
    balance += transaction.transactionAmount();
  }

  public double getBalance() {
    return balance;
  }

  public void suspendAccount() {
    suspended = true;
  }

  public void unsuspendAccount() {
    suspended = false;
  }

  public boolean isSuspended() {
    return suspended;
  }

  public double getOverdraftLimit() {
    return overdraftLimit;
  }

  public void setOverdraftLimit(double overdraftLimit) {
    this.overdraftLimit = overdraftLimit;
  }

  public void printBalance() {
    System.out.println("Balance for account: " + name + " = " + balance);
  }
}
