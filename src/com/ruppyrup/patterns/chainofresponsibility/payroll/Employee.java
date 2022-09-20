package com.ruppyrup.patterns.chainofresponsibility.payroll;

public class Employee {
  public enum PayType {SALARIED, COMMISSIONED, HOURLY};
  public enum PaySchedule {WEEKLY, BIWEEKLY, MONTHLY};
  public enum PayDeduction {NONE, UNION};
  public enum PayDisposition {MAIL, DIRECT, PAYMASTER};
  public PayType payType;
  public PaySchedule paySchedule;
  public PayDeduction payDeduction;
  public PayDisposition payDisposition;
}

