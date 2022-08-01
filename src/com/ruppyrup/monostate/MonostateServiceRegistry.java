package com.ruppyrup.monostate;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * All variables are static and all the methods non-static
 */
public class MonostateServiceRegistry {
  private static Map<String, Service> services;
  private static boolean initialized = false;

  public MonostateServiceRegistry() {
    if (!initialized) {
      services = new WeakHashMap<>();
      initialized = true;
    }
  }

  public void register(String name, Service service) {
    services.put(name, service);
  }

  public Service getService(String name) {
    return services.get(name);
  }
}
