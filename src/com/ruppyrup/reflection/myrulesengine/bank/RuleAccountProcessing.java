package com.ruppyrup.reflection.myrulesengine.bank;

import com.ruppyrup.reflection.myrulesengine.bankengine.BankRule;
import com.ruppyrup.reflection.myrulesengine.bankengine.BankRulesEngine;
import com.ruppyrup.reflection.myrulesengine.bankengine.DefaultBankRulesEngine;
import java.util.function.BiConsumer;

public class RuleAccountProcessing {

  public static void main(String[] args) {
    BiConsumer<Transaction, RuleAccount> defaultAction = (transaction, account) -> account.processTransaction(transaction);

    BankRulesEngine<Transaction, RuleAccount> engine = new DefaultBankRulesEngine<>(defaultAction);
    BankRule<Transaction, RuleAccount> suspendRule = new SuspendedRule(1, "supended rule");
    BankRule<Transaction, RuleAccount> overdraftRule = new OverdrawnRule(2, "overdraft rule");

    engine.addRule(suspendRule);
    engine.addRule(overdraftRule);

    RuleAccount account = new RuleAccount("Rule Account");

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
  }

}
