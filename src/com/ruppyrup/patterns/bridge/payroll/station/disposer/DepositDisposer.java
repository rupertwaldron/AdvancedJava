package com.ruppyrup.patterns.bridge.payroll.station.disposer;


import com.ruppyrup.patterns.bridge.payroll.Paycheck;

public class DepositDisposer extends PaymentDisposer {
  protected boolean doPaycheck(Paycheck paycheck) {
    // do direct deposit
    return true;
  }
}
