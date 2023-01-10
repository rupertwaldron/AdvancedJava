package com.ruppyrup.batchprocessor;

public class AddProcessor extends ProcessorStep<Integer>{

  @Override
  public void applyTo(Integer input) {
    int interim = input + 10;
    if (finalStep != null) {
      finalStep.write(interim);
    }
    if (nextStep != null) {
      nextStep.applyTo(interim);
    }
  }
}
