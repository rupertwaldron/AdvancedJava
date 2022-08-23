package com.ruppyrup.reflection.myrulesengine.bank;

import com.ruppyrup.reflection.myrulesengine.bankengine.BankRule;
import com.ruppyrup.reflection.myrulesengine.bankengine.BankRulesEngine;
import com.ruppyrup.reflection.myrulesengine.bankengine.DefaultBankRulesEngine;
import java.util.function.BiConsumer;

public class RuleAccountProcessing {

  public static void main(String[] args) {
    BiConsumer<Transaction, Account> defaultAction = (transaction, account) -> account.processTransaction(transaction);

    BankRulesEngine<Transaction, Account> engine = new DefaultBankRulesEngine<>(defaultAction);
    BankRule<Transaction, Account> suspendRule = new SuspendedRule(1, "supended rule");
    BankRule<Transaction, Account> overdraftRule = new OverdrawnRule(2, "overdraft rule");

    engine.addRule(suspendRule);
    engine.addRule(overdraftRule);

    Account account = new RuleAccount("Rule Account");

    account.printBalance();
    engine.fireUp(new Transaction(20), account);
    account.printBalance();
    engine.fireUp(new Transaction(100), account);
    account.printBalance();
    engine.fireUp(new Transaction(-300), account);
    account.printBalance();
    account.suspendAccount();
    engine.fireUp(new Transaction(-300), account);
    account.printBalance();
    account.unsuspendAccount();
    engine.fireUp(new Transaction(-100), account);
    account.printBalance();

    System.out.println("***********Normal Account*******************");

    Account normal = new NormalAccount("Normal Account");

    normal.printBalance();
    normal.processTransaction(new Transaction(20));
    normal.printBalance();
    normal.processTransaction(new Transaction(100));
    normal.printBalance();
    normal.processTransaction(new Transaction(-300));
    normal.printBalance();
    normal.suspendAccount();
    normal.processTransaction(new Transaction(-300));
    normal.printBalance();
    normal.unsuspendAccount();
    normal.processTransaction(new Transaction(-100));
    normal.printBalance();
  }

}
