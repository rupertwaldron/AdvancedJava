package com.ruppyrup.batchprocessor;

import java.util.Scanner;

public class ConsoleReader extends ReaderStep<Integer>{

  private final Scanner scanner = new Scanner(System.in);

  @Override
  Integer read() {
    int input = scanner.nextInt();
    return nextStep != null ? nextStep.applyTo(input) : input;
  }
}
