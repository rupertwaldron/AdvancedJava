package com.ruppyrup.patterns.chainofresponsibility.payroll.station.disposer;


import static com.ruppyrup.patterns.chainofresponsibility.payroll.Employee.PayDisposition.MAIL;

import com.ruppyrup.patterns.chainofresponsibility.payroll.Paycheck;
import com.ruppyrup.patterns.chainofresponsibility.payroll.station.PaycheckStation;

public class MailDisposer extends PaycheckStation {
  public MailDisposer(PaycheckStation nextStation) {
    super(nextStation);
  }

  protected boolean doPaycheck(Paycheck paycheck) {
    if (paycheck.employee.payDisposition == MAIL) {
      // mail paycheck
    }
    return true;
  }
}
