package com.ruppyrup.batchprocessor;

public class ConsoleWriter extends WriterStep<Integer>{

  @Override
  void write(Integer output) {
    System.out.println("Result = " + output);
  }
}
