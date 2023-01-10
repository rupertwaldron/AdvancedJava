package com.ruppyrup.completeablefutures.basic;

import java.util.concurrent.CompletableFuture;

public class CFTest {

  public static void main(String[] args) throws InterruptedException {

    CompletableFuture.runAsync(() -> {
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      System.out.println("Thread finished -> " + Thread.currentThread().getName());
    });

    for (int i = 0; i < 10; i++) {
      System.out.println("Main is running " + Thread.currentThread().getName());
      Thread.sleep(2000);
    }


  }

}
