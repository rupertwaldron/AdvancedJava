package com.ruppyrup.patterns.bridge.payroll;

import com.ruppyrup.patterns.bridge.payroll.station.PaycheckStation;
import com.ruppyrup.patterns.bridge.payroll.station.calculator.PaymentCalculator;
import com.ruppyrup.patterns.bridge.payroll.station.deductor.PaymentDeductor;
import com.ruppyrup.patterns.bridge.payroll.station.disposer.PaymentDisposer;
import com.ruppyrup.patterns.bridge.payroll.station.scheduler.PaymentScheduler;

public class Employee {
  private PaymentScheduler scheduler;
  private PaymentCalculator calculator;
  private PaymentDeductor deductor;
  private PaymentDisposer disposer;
  public PaycheckStation getDisposer() {
    disposer.setNext(null);
    return disposer;
  }
  public PaycheckStation getDeductorAndBridgeTo(PaycheckStation next) {
    deductor.setNext(next);
    return deductor;
  }
  public PaycheckStation getCalculatorAndBridgeTo(PaycheckStation next) {
    calculator.setNext(next);
    return calculator;
  }
  public PaycheckStation getSchedulerAndBridgeTo(PaycheckStation next) {
    scheduler.setNext(next);
    return scheduler;
  }
  public void setScheduler(PaymentScheduler scheduler) {
    this.scheduler = scheduler;
  }
  public void setCalculator(PaymentCalculator calculator) {
    this.calculator = calculator;
  }
  public void setDeductor(PaymentDeductor deductor) {
    this.deductor = deductor;
  }
  public void setDisposer(PaymentDisposer disposer) {
    this.disposer = disposer;
  }
}
