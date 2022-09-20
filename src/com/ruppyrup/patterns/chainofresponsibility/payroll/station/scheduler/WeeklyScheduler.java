package com.ruppyrup.patterns.chainofresponsibility.payroll.station.scheduler;

import static com.ruppyrup.patterns.chainofresponsibility.payroll.Employee.PaySchedule.WEEKLY;

import com.ruppyrup.patterns.chainofresponsibility.payroll.Paycheck;
import com.ruppyrup.patterns.chainofresponsibility.payroll.station.PaycheckStation;

public class WeeklyScheduler extends PaycheckStation {
  public WeeklyScheduler(PaycheckStation nextStation) {
    super(nextStation);
  }

  protected boolean doPaycheck(Paycheck paycheck) {
    if (paycheck.employee.paySchedule == WEEKLY) {
      return shouldPayToday();
    } else {
      return true;
    }
  }

  private boolean shouldPayToday() {
    return false; // determine if WEEKLY.
  }
}
