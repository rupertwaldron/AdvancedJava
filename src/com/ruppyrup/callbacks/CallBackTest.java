package com.ruppyrup.callbacks;

import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class CallBackTest {

  public static void main(String[] args) throws InterruptedException {
    Bob bob = new Bob();
    CallBackTest ct = new CallBackTest();

    ct.countToX(10, bob::sayHello);

  }

  public void countToX(int x, Consumer<String> callback) throws InterruptedException {
    for (int i = 0; i < x; i++) {
      TimeUnit.SECONDS.sleep(1);
    }
    callback.accept("Simon");
  }


}

class Bob {
  private String name = "Trevor";
  public void sayHello(String friend) {
    System.out.println("Hello " + friend + " my name is "+ name + ".");
  }
}
