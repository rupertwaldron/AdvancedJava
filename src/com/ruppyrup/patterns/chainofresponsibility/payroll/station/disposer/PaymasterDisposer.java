package com.ruppyrup.patterns.chainofresponsibility.payroll.station.disposer;

import static com.ruppyrup.patterns.chainofresponsibility.payroll.Employee.PayDisposition.PAYMASTER;

import com.ruppyrup.patterns.chainofresponsibility.payroll.Paycheck;
import com.ruppyrup.patterns.chainofresponsibility.payroll.station.PaycheckStation;

public class PaymasterDisposer extends PaycheckStation {
  public PaymasterDisposer(PaycheckStation nextStation) {
    super(nextStation);
  }

  protected boolean doPaycheck(Paycheck paycheck) {
    if (paycheck.employee.payDisposition == PAYMASTER) {
      // Send paycheck to paymaster.
    }
    return true;
  }
}
