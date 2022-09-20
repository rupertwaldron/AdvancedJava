package com.ruppyrup.patterns.bridge.payroll.station.calculator;

import com.ruppyrup.patterns.bridge.payroll.Paycheck;

public class SalariedCalculator extends PaymentCalculator {
  protected boolean doPaycheck(Paycheck paycheck) {
    // do calculation
    return true;
  }
}
