package com.ruppyrup.patterns.chainofresponsibility.payroll;

public class Paycheck {
  public Employee employee;

  public Paycheck(Employee e) {
    this.employee = e;
  }
}
