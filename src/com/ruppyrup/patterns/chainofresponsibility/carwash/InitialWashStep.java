package com.ruppyrup.patterns.chainofresponsibility.carwash;

public class InitialWashStep extends CarWashStep {
    @Override
    Car applyTo(Car car) {
        System.out.println("Applying " + WashState.INITIAL + " step " + car);
        final Car newCar = car.updateState(WashState.INITIAL);
        return nextStep != null ? nextStep.applyTo(newCar) : newCar;
    }
}
