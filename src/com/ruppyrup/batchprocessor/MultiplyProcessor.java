package com.ruppyrup.batchprocessor;

public class MultiplyProcessor extends ProcessorStep<Integer> {

  @Override
  Integer applyTo(Integer input) {
    int interim = input * 12;
    return nextStep != null ? nextStep.applyTo(interim): interim;
  }
}
