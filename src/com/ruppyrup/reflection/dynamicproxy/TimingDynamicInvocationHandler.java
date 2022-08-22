package com.ruppyrup.reflection.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class TimingDynamicInvocationHandler implements InvocationHandler {
  private static Logger LOGGER = Logger.getLogger(TimingDynamicInvocationHandler.class.getName());
  private final Map<String, Method> timerMethods = new HashMap<>();
  private Object target;

  TimingDynamicInvocationHandler(Object target) {
    this.target = target;
    Arrays.stream(this.target.getClass().getDeclaredMethods())
        .filter(method -> method.isAnnotationPresent(Timer.class))
        .forEach(method -> timerMethods.put(method.getName(), method));
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    Object result = null;
    if (timerMethods.get(method.getName()) != null) {
      long start = System.nanoTime();
      result = method.invoke(target, args);
      long elapsed = System.nanoTime() - start;
      LOGGER.info("Executing " + method.getName() + " finished in " + elapsed + "ns");
    } else {
      result = method.invoke(target, args);
    }
    return result;
  }
}

