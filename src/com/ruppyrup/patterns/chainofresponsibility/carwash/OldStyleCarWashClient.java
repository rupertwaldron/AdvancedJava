package com.ruppyrup.patterns.chainofresponsibility.carwash;

public class OldStyleCarWashClient {
    public static void main(String[] args) {
        Car car = new Car("Ford", "Mondeo");

        final CarWashStep chain = new InitialWashStep();

        chain.andThen(new SoapStep())
            .andThen(new RinseStep())
            .andThen(new PolishStep());

        Car finalCar = chain.applyTo(car);

        System.out.println("Final car state is " + finalCar.washState() + " : " + finalCar);


        Car funcCar = new Car("BMW", "M3");

        RupFunction<Car> initial = c -> funcCar;

        RupFunction<Car> funcChain = initial
                .andThen(getCarCarFunction(WashState.INITIAL))
                .andThen(getCarCarFunction(WashState.RINSE))
                .andThen(getCarCarFunction(WashState.POLISH));

        Car funcFinalCar = funcChain.apply(funcCar);

        System.out.println("Func Final Car state is " + funcFinalCar.washState()+ " : " + funcFinalCar);
    }

    private static RupFunction<Car> getCarCarFunction(WashState initial) {
        return car1 -> {
            System.out.println("Applying " + initial + " step " + car1);
            return car1.updateState(initial);
        };
    }
}
