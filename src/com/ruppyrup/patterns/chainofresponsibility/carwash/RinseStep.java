package com.ruppyrup.patterns.chainofresponsibility.carwash;

public class RinseStep extends CarWashStep {
    @Override
    Car applyTo(Car car) {
        System.out.println("Applying " + WashState.RINSE + " step " + car);
        final Car newCar = car.updateState(WashState.RINSE);
        return nextStep != null ? nextStep.applyTo(newCar) : newCar;

    }
}
