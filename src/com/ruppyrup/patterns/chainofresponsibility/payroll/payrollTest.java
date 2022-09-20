package com.ruppyrup.patterns.chainofresponsibility.payroll;


import static com.ruppyrup.patterns.chainofresponsibility.payroll.Employee.PaySchedule.MONTHLY;
import static com.ruppyrup.patterns.chainofresponsibility.payroll.Employee.PaySchedule.WEEKLY;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.ruppyrup.patterns.chainofresponsibility.payroll.Employee.PayDeduction;
import com.ruppyrup.patterns.chainofresponsibility.payroll.Employee.PayDisposition;
import com.ruppyrup.patterns.chainofresponsibility.payroll.Employee.PaySchedule;
import com.ruppyrup.patterns.chainofresponsibility.payroll.Employee.PayType;
import com.ruppyrup.patterns.chainofresponsibility.payroll.station.PaycheckStation;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class payrollTest {
  private String marks = "";
  private List<Employee> employees = new ArrayList<>();

  class Marker<T> extends PaycheckStation {
    private final String mark;
    private final T type;

    public Marker(String mark, T stationType, PaycheckStation nextStation) {
      super(nextStation);
      this.mark = mark;
      this.type = stationType;
    }

    protected boolean doPaycheck(Paycheck paycheck) {
      if (isForThisStation(paycheck.employee))
        marks = marks + mark;
      return true;
    }

    private boolean isForThisStation(Employee e) {
      return type instanceof PaySchedule && type == e.paySchedule ||
        type instanceof PayType && type == e.payType ||
        type instanceof PayDeduction && type == e.payDeduction ||
        type instanceof PayDisposition && type == e.payDisposition;
    }
  }

  @BeforeEach
  public void setup() {
  }

  @Test
  public void singleStation() throws Exception {
    Employee weekly = new Employee();
    weekly.paySchedule = WEEKLY;
    employees.add(weekly);

    Payroll payroll = new Payroll(employees);
    payroll.paycheckStations = new Marker<PaySchedule>("X", WEEKLY, null);
    payroll.payday();
    assertEquals("X", marks);
  }

  @Test
  public void twoStations() throws Exception {
    Employee weekly = new Employee();
    weekly.paySchedule = WEEKLY;
    Employee monthly = new Employee();
    monthly.paySchedule = MONTHLY;
    employees.add(weekly);
    employees.add(monthly);

    Payroll payroll = new Payroll(employees);
    payroll.paycheckStations =
      new Marker<PaySchedule>("W", WEEKLY,
        new Marker<PaySchedule>("M", MONTHLY, null));
    payroll.payday();
    assertEquals("WM", marks);
  }

}
