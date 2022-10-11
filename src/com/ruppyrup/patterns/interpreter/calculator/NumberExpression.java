package com.ruppyrup.patterns.interpreter.calculator;

public class NumberExpression implements Expression {
  private final int number;
  public NumberExpression(int number) {
    this.number = number;
  }
  public NumberExpression(String number) {
    this.number = Integer.parseInt(number);
  }
  @Override
  public int interpret() {
    return number;
  }
}
