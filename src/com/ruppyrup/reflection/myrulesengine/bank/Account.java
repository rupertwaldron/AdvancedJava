package com.ruppyrup.reflection.myrulesengine.bank;

import java.util.logging.Logger;

public class Account {

  private static final Logger LOGGER = Logger.getLogger(Account.class.getName());
  private final String name;
  private double balance;
  private boolean suspended = false;
  private final double overdraftLimit = -100.0;

  public Account(String name) {
    this.name = name;
  }

  public void addMoney(double amount) {
    if (suspended) LOGGER.info("Your account is suspended" );

    balance += amount;
  }

  public void withDrawMoney(double amount) {
    if (suspended) LOGGER.info("Your account is suspended" );

    var predictedBalance = balance - amount;

    if (predictedBalance < overdraftLimit) {
      LOGGER.info("Withdrawing this amount takes you over your overdraft limit");
    } else {
      balance -= amount;
    }
  }

  public String getBalance() {
    return "Balance for account: " + name + " = " + balance;
  }

  public void suspendAccount() {
    suspended = true;
  }

  public void unsuspendAccount() {
    suspended = false;
  }
}
