package com.ruppyrup.patterns.bridge.payroll.station.scheduler;

import com.ruppyrup.patterns.bridge.payroll.Paycheck;

public class WeeklyScheduler extends PaymentScheduler {
  protected boolean doPaycheck(Paycheck paycheck) {
    // determine weekly schedule
    return true;
  }
}
