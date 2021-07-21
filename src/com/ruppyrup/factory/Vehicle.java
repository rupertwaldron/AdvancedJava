package com.ruppyrup.factory;

public abstract class Vehicle implements Driveable {
    protected VehicleColor color;

    public Vehicle(VehicleColor color) {
        this.color = color;
    }

    public String display() {
        return this.getClass().getSimpleName() + " of color " + color.toString().toLowerCase();
    }

}
