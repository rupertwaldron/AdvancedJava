package com.ruppyrup.patterns.factory;

public class Driving {
    public static void main(String[] args) {
        Vehicle vehicle = VehicleTypeLambda.CAR.createVehicle(VehicleColor.BLUE);
        System.out.println(vehicle.display());
        vehicle.start(nil -> {
            System.out.println("Put foot on brake");
            System.out.println("Press start button");
        });
    }
}
