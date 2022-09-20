package com.ruppyrup.patterns.chainofresponsibility.carwash;

public class SoapStep extends CarWashStep {
    @Override
    Car applyTo(Car car) {
        System.out.println("Applying " + WashState.SOAP + " step " + car);
        final Car newCar = car.updateState(WashState.SOAP);
        return nextStep != null ? nextStep.applyTo(newCar) : newCar;

    }
}
