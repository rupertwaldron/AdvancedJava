package com.ruppyrup.batchprocessor;

public class BatchTest {

  public static void main(String[] args) {

    ReaderStep<Integer> reader = new ConsoleReader();

    ProcessorStep<Integer> step1 = new AddProcessor();
    ProcessorStep<String> step2 = new StringProcessor();
    ProcessorStep<Integer> step3 = new MultiplyProcessor();

    reader
        .andThen(step1)
        .andThen(step3);

    Integer result = reader.read();

    System.out.println(result);
  }

}
