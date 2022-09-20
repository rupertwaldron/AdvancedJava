package com.ruppyrup.patterns.bridge.payroll.station.calculator;

import com.ruppyrup.patterns.bridge.payroll.Paycheck;

public class CommissionedCalculator extends PaymentCalculator {
  protected boolean doPaycheck(Paycheck paycheck) {
    // do calculation
    return true;
  }
}
