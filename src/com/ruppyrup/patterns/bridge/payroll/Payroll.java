package com.ruppyrup.patterns.bridge.payroll;

import com.ruppyrup.patterns.bridge.payroll.station.PaycheckStation;
import java.util.List;

public class Payroll {
  private List<Employee> employees;

  public Payroll(List<Employee> employees) {
    this.employees = employees;
  }

  public void payday() {
    for (Employee e : employees) {
      PaycheckStation start =
        e.getSchedulerAndBridgeTo(
          e.getCalculatorAndBridgeTo(
            e.getDeductorAndBridgeTo(
              e.getDisposer())));

      Paycheck pc = new Paycheck(e);
      start.handlePaycheck(pc);
    }
  }
}
