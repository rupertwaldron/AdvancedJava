package com.ruppyrup.batchprocessor;

public class AddProcessor extends ProcessorStep<Integer>{

  @Override
  Integer applyTo(Integer input) {
    int interim = input + 10;
    if (nextStep != null) {
      interim = nextStep.applyTo(interim);
    }
    if (finalStep != null) {

    }
    return nextStep != null ? nextStep.applyTo(interim) : interim;
  }
}
