package com.ruppyrup.patterns.chainofresponsibility.carwash;


import java.util.Objects;

@FunctionalInterface
public interface RupFunction<Car> {

    Car apply(Car car);

    default RupFunction<Car> andThen(RupFunction<Car> after) {
        Objects.requireNonNull(after);
        return car -> after.apply(apply(car));
    }

}
