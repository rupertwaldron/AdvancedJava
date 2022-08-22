package com.ruppyrup.patterns.factory;

import java.util.function.Function;

public enum VehicleTypeLambda {
    CAR(Car::new),
    BUS(Bus::new),
    TRUCK(Truck::new);

    public final Function<VehicleColor, Vehicle> factory;

    VehicleTypeLambda(Function<VehicleColor, Vehicle> factory) {
        this.factory = factory;
    }

    public Vehicle createVehicle(VehicleColor color) {
        return factory.apply(color);
    }
}
