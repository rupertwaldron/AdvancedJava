package com.ruppyrup.chainofresponsibility;

public class Car {
    private String make;
    private String model;
    private WashState washState;

    public Car(String make, String model) {
        this.make = make;
        this.model = model;
    }

    public Car updateState(WashState washState) {
        this.washState = washState;
        return this;
    }

    public WashState washState() {
        return washState;
    }


}
