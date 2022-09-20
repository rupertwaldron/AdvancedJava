package com.ruppyrup.patterns.bridge.payroll.station.scheduler;

import com.ruppyrup.patterns.bridge.payroll.Paycheck;

public class MonthlyScheduler extends PaymentScheduler {
  protected boolean doPaycheck(Paycheck paycheck) {
    // determine Monthly schedule.
    return true;
  }
}
