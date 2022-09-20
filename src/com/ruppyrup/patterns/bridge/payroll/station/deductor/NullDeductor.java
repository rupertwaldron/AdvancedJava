package com.ruppyrup.patterns.bridge.payroll.station.deductor;

import com.ruppyrup.patterns.bridge.payroll.Paycheck;

public class NullDeductor extends PaymentDeductor {
  protected boolean doPaycheck(Paycheck paycheck) {
    // deduct nothing.
    return true;
  }
}
