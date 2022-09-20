package com.ruppyrup.patterns.chainofresponsibility.payroll.station.calculator;

import static com.ruppyrup.patterns.chainofresponsibility.payroll.Employee.PayType.HOURLY;

import com.ruppyrup.patterns.chainofresponsibility.payroll.Paycheck;
import com.ruppyrup.patterns.chainofresponsibility.payroll.station.PaycheckStation;
public class HourlyCalculator extends PaycheckStation {
  public HourlyCalculator(PaycheckStation nextStation) {
    super(nextStation);
  }

  protected boolean doPaycheck(Paycheck paycheck) {
    if (paycheck.employee.payType == HOURLY) {
      // do calculation
    }
    return true;
  }
}
