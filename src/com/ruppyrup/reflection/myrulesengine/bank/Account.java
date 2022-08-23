package com.ruppyrup.reflection.myrulesengine.bank;

public interface Account {

  void processTransaction(Transaction transaction);

  double getBalance();

  void suspendAccount();

  void unsuspendAccount();

  boolean isSuspended();

  double getOverdraftLimit();

  void setOverdraftLimit(double overdraftLimit);

  void printBalance();
}
