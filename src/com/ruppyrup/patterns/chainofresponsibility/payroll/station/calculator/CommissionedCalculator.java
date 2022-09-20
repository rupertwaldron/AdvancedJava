package com.ruppyrup.patterns.chainofresponsibility.payroll.station.calculator;

import static com.ruppyrup.patterns.chainofresponsibility.payroll.Employee.PayType.COMMISSIONED;

import com.ruppyrup.patterns.chainofresponsibility.payroll.Paycheck;
import com.ruppyrup.patterns.chainofresponsibility.payroll.station.PaycheckStation;

public class CommissionedCalculator extends PaycheckStation {
  public CommissionedCalculator(PaycheckStation nextStation) {
    super(nextStation);
  }

  protected boolean doPaycheck(Paycheck paycheck) {
    if (paycheck.employee.payType == COMMISSIONED) {
      // do calculation
    }
    return true;
  }
}
