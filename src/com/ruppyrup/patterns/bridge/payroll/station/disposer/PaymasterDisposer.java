package com.ruppyrup.patterns.bridge.payroll.station.disposer;

import com.ruppyrup.patterns.bridge.payroll.Paycheck;

public class PaymasterDisposer extends PaymentDisposer {
  protected boolean doPaycheck(Paycheck paycheck) {
    // Send paycheck to paymaster.
    return true;
  }
}
