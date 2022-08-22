package com.ruppyrup.reflection.myrulesengine.bank;

public class NormalAccountProcessing {

  public static void main(String[] args) {
    Account myAccount = new Account("Rupert");
    myAccount.withDrawMoney(100);
    System.out.println(myAccount.getBalance());
    myAccount.withDrawMoney(10);
    myAccount.addMoney(200);
    System.out.println(myAccount.getBalance());
    myAccount.addMoney(500);
    System.out.println(myAccount.getBalance());
  }

}
