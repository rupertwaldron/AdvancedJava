package com.ruppyrup.reflection.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class TimerTest {

  public static void main(String[] args) {
    Calculator calculator = new Calculation(8, 15);
    TimingDynamicInvocationHandler invocationHandler = new TimingDynamicInvocationHandler(calculator);

//    Calculator proxy = asProxy(calculator);

    Calculator proxy = asGenericProxy(calculator, invocationHandler, Calculator.class);

    System.out.println(proxy.add());
    System.out.println(proxy.sub());
    System.out.println(proxy.hypot());
  }

  static Calculator asProxy(Calculator calculator) {
    return (Calculator) Proxy.newProxyInstance(calculator.getClass().getClassLoader(), new Class[]{Calculator.class}, new TimingDynamicInvocationHandler(
        calculator));
  }

  @SuppressWarnings("unchecked")
  static <T> T asGenericProxy(T clasToProxy, InvocationHandler invocationHandler, Class<?>... clazz) {
    return (T) Proxy.newProxyInstance(clasToProxy.getClass().getClassLoader(), clazz, invocationHandler);
  }
}
