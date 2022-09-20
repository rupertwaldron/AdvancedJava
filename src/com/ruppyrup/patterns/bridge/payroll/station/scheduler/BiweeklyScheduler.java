package com.ruppyrup.patterns.bridge.payroll.station.scheduler;

import com.ruppyrup.patterns.bridge.payroll.Paycheck;

public class BiweeklyScheduler extends PaymentScheduler {
  protected boolean doPaycheck(Paycheck paycheck) {
    // determine biweekly schedule
    return true;
  }
}
