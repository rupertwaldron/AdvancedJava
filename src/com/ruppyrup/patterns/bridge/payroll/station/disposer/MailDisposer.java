package com.ruppyrup.patterns.bridge.payroll.station.disposer;


import com.ruppyrup.patterns.bridge.payroll.Paycheck;

public class MailDisposer extends PaymentDisposer {
  protected boolean doPaycheck(Paycheck paycheck) {
    // mail paycheck.
    return true;
  }
}
