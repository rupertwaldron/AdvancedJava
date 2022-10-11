package com.ruppyrup.batchprocessor;

public abstract class ProcessorStep<T> {
    protected ProcessorStep<T> nextStep;

    public ProcessorStep<T> andThen(ProcessorStep<T> nextStep) {
        this.nextStep = nextStep;
        return nextStep;
    }

    abstract T applyTo(T input);
}
