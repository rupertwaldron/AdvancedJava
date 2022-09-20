package com.ruppyrup.patterns.chainofresponsibility.payroll.station.deductor;

import static com.ruppyrup.patterns.chainofresponsibility.payroll.Employee.PayDeduction.UNION;

import com.ruppyrup.patterns.chainofresponsibility.payroll.Paycheck;
import com.ruppyrup.patterns.chainofresponsibility.payroll.station.PaycheckStation;

public class UnionDeductor extends PaycheckStation {
  public UnionDeductor(PaycheckStation nextStation) {
    super(nextStation);
  }

  protected boolean doPaycheck(Paycheck paycheck) {
    if (paycheck.employee.payDeduction == UNION) {
      // do calculation
    }    return true;
  }
}
