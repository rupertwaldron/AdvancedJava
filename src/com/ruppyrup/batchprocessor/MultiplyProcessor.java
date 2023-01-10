package com.ruppyrup.batchprocessor;

public class MultiplyProcessor extends ProcessorStep<Integer> {

  @Override
  public void applyTo(Integer input) {
    int interim = input * 12;
    if (finalStep != null) {
      finalStep.write(interim);
    }
    if (nextStep != null) {
      nextStep.applyTo(interim);
    }
  }
}
