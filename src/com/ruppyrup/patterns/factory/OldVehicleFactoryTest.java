package com.ruppyrup.patterns.factory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class OldVehicleFactoryTest {

    @Test
    void createCar() {
        Vehicle vehicle = OldVehicleFactory.createVehicle(VehicleType.CAR, VehicleColor.BLUE);
        Assertions.assertTrue(vehicle instanceof Car);
        Assertions.assertEquals("Car of color blue", vehicle.display());
    }

    @Test
    void createBus() {
        Vehicle vehicle = OldVehicleFactory.createVehicle(VehicleType.BUS, VehicleColor.RED);
        Assertions.assertTrue(vehicle instanceof Bus);
        Assertions.assertEquals("Bus of color red", vehicle.display());
    }

    @Test
    void createTruck() {
        Vehicle vehicle = OldVehicleFactory.createVehicle(VehicleType.TRUCK, VehicleColor.GREEN);
        Assertions.assertTrue(vehicle instanceof Truck);
        Assertions.assertEquals("Truck of color green", vehicle.display());
    }
}
