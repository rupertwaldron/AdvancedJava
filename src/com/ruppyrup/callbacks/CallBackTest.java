package com.ruppyrup.callbacks;

import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class CallBackTest {

  public static void main(String[] args) throws InterruptedException {
    Bob bob = new Bob();
    CallBack trev = new Trev();
    CallBackTest ct = new CallBackTest();

    ct.countToX(10, bob::sayHello);

    ct.doSomething(friend -> System.out.println("Anon says hello to " + friend),
        CallBack::sayHello, "Rupert");

    ct.doSomething(trev, CallBack::sayHello, "Rupert");

  }

  public void countToX(int x, Consumer<String> callback) throws InterruptedException {
    for (int i = 0; i < x; i++) {
      TimeUnit.SECONDS.sleep(1);
    }
    callback.accept("Simon");
  }

  public void doSomething(CallBack callback, BiConsumer<CallBack, String> consumer, String name) {
    consumer.accept(callback, name);
  }


}

interface CallBack {
  void sayHello(String friend);
}

class Bob implements CallBack {
  private String name = "Bob";
  @Override
  public void sayHello(String friend) {
    System.out.println("Hello " + friend + " my name is "+ name + ".");
  }
}

class Trev implements CallBack {
  private String name = "Trev";
  @Override
  public void sayHello(String friend) {
    System.out.println("Hello " + friend + " my name is "+ name + ".");
  }
}
