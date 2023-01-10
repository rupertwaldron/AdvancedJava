package com.ruppyrup.batchprocessor;

public abstract class ProcessorStep<T> {
    protected ProcessorStep<T> nextStep;
    protected WriterStep<T> finalStep;

    public ProcessorStep<T> andThen(ProcessorStep<T> nextStep) {
        this.nextStep = nextStep;
        return nextStep;
    }

    public void andFinally(WriterStep<T> writerStep) {
        this.finalStep = writerStep;
    }

    protected

    abstract void applyTo(T input);
}
