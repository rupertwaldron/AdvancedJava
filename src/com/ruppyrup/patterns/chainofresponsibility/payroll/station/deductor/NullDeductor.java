package com.ruppyrup.patterns.chainofresponsibility.payroll.station.deductor;

import static com.ruppyrup.patterns.chainofresponsibility.payroll.Employee.PayDeduction.NONE;

import com.ruppyrup.patterns.chainofresponsibility.payroll.Paycheck;
import com.ruppyrup.patterns.chainofresponsibility.payroll.station.PaycheckStation;

public class NullDeductor extends PaycheckStation {
  public NullDeductor(PaycheckStation nextStation) {
    super(nextStation);
  }

  protected boolean doPaycheck(Paycheck paycheck) {
    if (paycheck.employee.payDeduction == NONE) {
      // do calculation
    }
    return true;
  }
}
