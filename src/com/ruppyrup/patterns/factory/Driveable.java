package com.ruppyrup.patterns.factory;

import java.util.function.Consumer;

public interface Driveable {
    default void start(Consumer<Void> preStartChecks) {
        preStartChecks.accept(null);
        System.out.println(this.getClass().getSimpleName() + " is staring....");
    }
}
