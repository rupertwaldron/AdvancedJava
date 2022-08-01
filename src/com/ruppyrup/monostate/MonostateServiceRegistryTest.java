package com.ruppyrup.monostate;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MonostateServiceRegistryTest {

  @Test
  void addedServiceCanBeRetrieved() {
    Service s = new Service();
    MonostateServiceRegistry r1 = new MonostateServiceRegistry();
    MonostateServiceRegistry r2 = new MonostateServiceRegistry();

    r1.register("ServiceName", s);
    assertEquals(s, r2.getService("ServiceName"));
  }

}
