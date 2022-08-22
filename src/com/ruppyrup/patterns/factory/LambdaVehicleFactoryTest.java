package com.ruppyrup.patterns.factory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LambdaVehicleFactoryTest {

    @Test
    void createCar() {
        Vehicle vehicle = VehicleTypeLambda.CAR.createVehicle(VehicleColor.BLUE);
        Assertions.assertTrue(vehicle instanceof Car);
        Assertions.assertEquals("Car of color blue", vehicle.display());
    }

    @Test
    void createBus() {
        Vehicle vehicle = VehicleTypeLambda.BUS.createVehicle(VehicleColor.RED);
        Assertions.assertTrue(vehicle instanceof Bus);
        Assertions.assertEquals("Bus of color red", vehicle.display());
    }

    @Test
    void createTruck() {
        Vehicle vehicle = VehicleTypeLambda.TRUCK.createVehicle(VehicleColor.GREEN);
        Assertions.assertTrue(vehicle instanceof Truck);
        Assertions.assertEquals("Truck of color green", vehicle.display());
    }
}
