package com.ruppyrup.patterns.chainofresponsibility.payroll.station.scheduler;

import static com.ruppyrup.patterns.chainofresponsibility.payroll.Employee.PaySchedule.MONTHLY;

import com.ruppyrup.patterns.chainofresponsibility.payroll.Paycheck;
import com.ruppyrup.patterns.chainofresponsibility.payroll.station.PaycheckStation;

public class MonthlyScheduler extends PaycheckStation {
  public MonthlyScheduler(PaycheckStation nextStation) {
    super(nextStation);
  }

  protected boolean doPaycheck(Paycheck paycheck) {
    if (paycheck.employee.paySchedule == MONTHLY) {
      return shouldPayToday();
    } else {
      return true;
    }
  }

  private boolean shouldPayToday() {
    return false; // determine if Monthly.
  }
}
