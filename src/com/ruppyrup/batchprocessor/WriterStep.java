package com.ruppyrup.batchprocessor;

public abstract class WriterStep<T> {

  abstract void write(T output);
}
