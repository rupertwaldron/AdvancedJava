package com.ruppyrup.batchprocessor;

public class BatchTest {

  public static void main(String[] args) {

    ReaderStep<Integer> reader = new ConsoleReader();
    WriterStep<Integer> writer = new ConsoleWriter();

    ProcessorStep<Integer> step1 = new AddProcessor();
    ProcessorStep<Integer> step3 = new MultiplyProcessor();

    reader
        .andThen(step1)
        .andThen(step3)
        .andFinally(writer);

    reader.read();

  }

}
