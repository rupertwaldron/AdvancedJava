package com.ruppyrup.batchprocessor;

public class ConsoleWriter extends WriterStep<String>{

  @Override
  void write(String output) {
    System.out.println("Result = " + output);
  }
}
