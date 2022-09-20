package com.ruppyrup.patterns.bridge.payroll.station;

import com.ruppyrup.patterns.bridge.payroll.Paycheck;

public abstract class PaycheckStation {
  private PaycheckStation nextStation;

  public void handlePaycheck(Paycheck paycheck) {
    if (doPaycheck(paycheck) && nextStation != null)
      nextStation.handlePaycheck(paycheck);
  }
  protected abstract boolean doPaycheck(Paycheck paycheck);

  public PaycheckStation setNext(PaycheckStation next) {
    this.nextStation = next;
    return this;
  }
}
