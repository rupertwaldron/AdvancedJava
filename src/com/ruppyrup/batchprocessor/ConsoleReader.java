package com.ruppyrup.batchprocessor;

import java.util.Scanner;

public class ConsoleReader extends ReaderStep<Integer>{

  private final Scanner scanner = new Scanner(System.in);

  @Override
  public void read() {
    int input = scanner.nextInt();
    if (nextStep != null) {
      nextStep.applyTo(input);
    }
  }
}
