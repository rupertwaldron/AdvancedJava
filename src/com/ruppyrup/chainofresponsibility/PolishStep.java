package com.ruppyrup.chainofresponsibility;

public class PolishStep extends CarWashStep {
    @Override
    Car applyTo(Car car) {
        System.out.println("Applying " + WashState.POLISH + " step " + car);
        final Car newCar = car.updateState(WashState.POLISH);
        return nextStep != null ? nextStep.applyTo(newCar) : newCar;
    }
}
