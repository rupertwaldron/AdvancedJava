package com.ruppyrup.reflection.myrulesengine.bank;

import java.util.logging.Logger;

public class NormalAccount implements Account {

  private static final Logger LOGGER = Logger.getLogger(NormalAccount.class.getName());
  private final String name;
  private double balance;
  private boolean suspended = false;
  private double overdraftLimit = -100.0;

  public NormalAccount(String name) {
    this.name = name;
  }

  @Override
  public void processTransaction(Transaction transaction) {
    if (suspended) LOGGER.info("Your account is suspended");

    var predictedBalance = balance + transaction.transactionAmount();

    if (predictedBalance < overdraftLimit) {
      LOGGER.info("Withdrawing this amount takes you over your overdraft limit");
    } else {
      balance += transaction.transactionAmount();
    }
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

  public void printBalance() {
    System.out.println("Balance for account: " + name + " = " + balance);
  }
}
