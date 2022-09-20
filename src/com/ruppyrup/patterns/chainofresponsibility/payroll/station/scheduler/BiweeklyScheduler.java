package com.ruppyrup.patterns.chainofresponsibility.payroll.station.scheduler;


import static com.ruppyrup.patterns.chainofresponsibility.payroll.Employee.PaySchedule.BIWEEKLY;

import com.ruppyrup.patterns.chainofresponsibility.payroll.Paycheck;
import com.ruppyrup.patterns.chainofresponsibility.payroll.station.PaycheckStation;

public class BiweeklyScheduler extends PaycheckStation {
  public BiweeklyScheduler(PaycheckStation nextStation) {
    super(nextStation);
  }

  protected boolean doPaycheck(Paycheck paycheck) {
    if (paycheck.employee.paySchedule == BIWEEKLY) {
      return shouldPayToday();
    } else {
      return true;
    }
  }

  private boolean shouldPayToday() {
    return false; // determine if BIWEEKLY.
  }
}
