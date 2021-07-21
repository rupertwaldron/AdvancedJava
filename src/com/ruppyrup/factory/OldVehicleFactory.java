package com.ruppyrup.factory;

public class OldVehicleFactory {
    public static Vehicle createVehicle(VehicleType type, VehicleColor color) {
        return switch(type) {
            case BUS -> new Bus(color);
            case CAR -> new Car(color);
            case TRUCK -> new Truck(color);
        };

    }
}
