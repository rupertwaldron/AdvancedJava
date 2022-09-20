package com.ruppyrup.patterns.bridge.payroll.station.deductor;

import com.ruppyrup.patterns.bridge.payroll.Paycheck;

public class UnionDeductor extends PaymentDeductor {
  protected boolean doPaycheck(Paycheck paycheck) {
    // deduct union dues, etc.
    return true;
  }
}
