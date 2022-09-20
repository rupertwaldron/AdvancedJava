package com.ruppyrup.patterns.bridge.payroll;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.ruppyrup.patterns.bridge.payroll.station.calculator.PaymentCalculator;
import com.ruppyrup.patterns.bridge.payroll.station.deductor.PaymentDeductor;
import com.ruppyrup.patterns.bridge.payroll.station.disposer.PaymentDisposer;
import com.ruppyrup.patterns.bridge.payroll.station.scheduler.PaymentScheduler;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class payrollTest {
  private String marks = "";
  private List<Employee> employees = new ArrayList<>();
  private Employee notToday = new Employee();
  private Employee today = new Employee();

  class MarkingScheduler extends PaymentScheduler {
    protected boolean doPaycheck(Paycheck paycheck) {
      marks = marks + "S";
      return true;
    }
  }

  class MarkingCalculator extends PaymentCalculator {
    protected boolean doPaycheck(Paycheck paycheck) {
      marks = marks + "C";
      return true;
    }
  }

  class MarkingDeductor extends PaymentDeductor {
    protected boolean doPaycheck(Paycheck paycheck) {
      marks = marks + "D";
      return true;
    }
  }

  class MarkingDisposer extends PaymentDisposer {
    protected boolean doPaycheck(Paycheck paycheck) {
      marks = marks + "P";
      return true;
    }
  }




  @BeforeEach
  public void setup() {
    notToday.setScheduler(new PaymentScheduler() {
      protected boolean doPaycheck(Paycheck paycheck) {
        return false;
      }
    });

    notToday.setCalculator(new MarkingCalculator());
    notToday.setDeductor(new MarkingDeductor());
    notToday.setDisposer(new MarkingDisposer());

    today.setScheduler(new PaymentScheduler() {
      protected boolean doPaycheck(Paycheck paycheck) {
        return true;
      }
    });

    today.setCalculator(new MarkingCalculator());
    today.setDeductor(new MarkingDeductor());
    today.setDisposer(new MarkingDisposer());
  }

  @Test
  public void notToday() throws Exception {
    employees.add(notToday);
    Payroll payroll = new Payroll(employees);
    payroll.payday();
    assertEquals("", marks);
  }

  @Test
  public void today() throws Exception {
    employees.add(today);
    Payroll payroll = new Payroll(employees);
    payroll.payday();
    assertEquals("CDP", marks);
  }
}
