package com.ruppyrup.patterns.chainofresponsibility.payroll;

import com.ruppyrup.patterns.chainofresponsibility.payroll.station.PaycheckStation;
import com.ruppyrup.patterns.chainofresponsibility.payroll.station.calculator.CommissionedCalculator;
import com.ruppyrup.patterns.chainofresponsibility.payroll.station.calculator.HourlyCalculator;
import com.ruppyrup.patterns.chainofresponsibility.payroll.station.calculator.SalariedCalculator;
import com.ruppyrup.patterns.chainofresponsibility.payroll.station.deductor.NullDeductor;
import com.ruppyrup.patterns.chainofresponsibility.payroll.station.deductor.UnionDeductor;
import com.ruppyrup.patterns.chainofresponsibility.payroll.station.disposer.DepositDisposer;
import com.ruppyrup.patterns.chainofresponsibility.payroll.station.disposer.MailDisposer;
import com.ruppyrup.patterns.chainofresponsibility.payroll.station.disposer.PaymasterDisposer;
import com.ruppyrup.patterns.chainofresponsibility.payroll.station.scheduler.BiweeklyScheduler;
import com.ruppyrup.patterns.chainofresponsibility.payroll.station.scheduler.MonthlyScheduler;
import com.ruppyrup.patterns.chainofresponsibility.payroll.station.scheduler.WeeklyScheduler;
import java.util.List;


public class Payroll {
  private List<Employee> employees;
  public PaycheckStation paycheckStations;
  public Payroll(List<Employee> employees) {
    this.employees = employees;
  }
  public void setupPaycheckStations() {
    paycheckStations =
      new WeeklyScheduler(
        new MonthlyScheduler(
          new BiweeklyScheduler(
            new HourlyCalculator(
              new SalariedCalculator(
                new CommissionedCalculator(
                  new NullDeductor(
                    new UnionDeductor(
                      new DepositDisposer(
                        new MailDisposer(
                          new PaymasterDisposer(null)
                        )
                      )
                    )
                  )
                )
              )
            )
          )
        )
      );
  }
  public void payday() {
    for (Employee e : employees) {
      Paycheck pc = new Paycheck(e);
      paycheckStations.handlePaycheck(pc);
    }
  }
}
