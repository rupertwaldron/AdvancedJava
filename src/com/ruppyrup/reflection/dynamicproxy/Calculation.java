package com.ruppyrup.reflection.dynamicproxy;

class Calculation implements Calculator {

  private double a;
  private double b;

  public Calculation(double a, double b) {
    this.a = a;
    this.b = b;
  }

  @Override
  @Timer
  public double add() {
    return a + b;
  }

  @Override
  public double sub() {
    return a - b;
  }

  @Override
  @Timer
  public double multiply() {
    return a * b;
  }

  @Override
  @Timer
  public double divide() {
    return a / b;
  }

  @Override
  @Timer
  public double hypot() {
    return Math.hypot(a, b);
  }
}
