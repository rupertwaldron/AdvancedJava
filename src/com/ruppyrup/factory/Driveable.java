package com.ruppyrup.factory;

import java.util.function.Consumer;

public interface Driveable {
    default void start(Consumer<Void> preStartChecks) {
        preStartChecks.accept(null);
        System.out.println(this.getClass().getSimpleName() + " is staring....");
    }
}
