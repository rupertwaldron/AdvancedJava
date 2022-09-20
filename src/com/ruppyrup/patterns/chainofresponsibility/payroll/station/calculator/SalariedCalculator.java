package com.ruppyrup.patterns.chainofresponsibility.payroll.station.calculator;

import static com.ruppyrup.patterns.chainofresponsibility.payroll.Employee.PayType.SALARIED;

import com.ruppyrup.patterns.chainofresponsibility.payroll.Paycheck;
import com.ruppyrup.patterns.chainofresponsibility.payroll.station.PaycheckStation;

public class SalariedCalculator extends PaycheckStation {
  public SalariedCalculator(PaycheckStation nextStation) {
    super(nextStation);
  }

  protected boolean doPaycheck(Paycheck paycheck) {
    if (paycheck.employee.payType == SALARIED) {
      // do calculation
    }
    return true;
  }
}
