package com.ruppyrup.reflection.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class DynamicInvocationHandler implements InvocationHandler {
  private static final Logger LOGGER = Logger.getLogger(DynamicInvocationHandler.class.getName());
  private final Map<String, Method> methods = new HashMap<>();
  private final Object target;

  public DynamicInvocationHandler(final Object target) {
    this.target = target;
    for(Method method: target.getClass().getDeclaredMethods()) {
      this.methods.put(method.getName(), method);
    }
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    LOGGER.info("Invoked method: " + method.getName());
    Object result = methods.get(method.getName()).invoke(target, args);
    return result;
  }

}

class DynamicProxyTest {
  public static void main(String[] args) {
    Map<String, String> myMap = new HashMap<>();

    Map proxyInstance = (Map) Proxy.newProxyInstance(myMap.getClass().getClassLoader(), new Class[]{Map.class}, new DynamicInvocationHandler(myMap));

    System.out.println(proxyInstance.put("hello", "world")); // returns 42

    System.out.println(proxyInstance.get("hello"));
  }

}
