package com.ruppyrup.patterns.chainofresponsibility.payroll.station.disposer;


import static com.ruppyrup.patterns.chainofresponsibility.payroll.Employee.PayDisposition.DIRECT;

import com.ruppyrup.patterns.chainofresponsibility.payroll.Paycheck;
import com.ruppyrup.patterns.chainofresponsibility.payroll.station.PaycheckStation;

public class DepositDisposer extends PaycheckStation {
  public DepositDisposer(PaycheckStation nextStation) {
    super(nextStation);
  }

  protected boolean doPaycheck(Paycheck paycheck) {
    if (paycheck.employee.payDisposition == DIRECT) {
      // deposit paycheck
    }
    return true;
  }
}
