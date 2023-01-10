package com.ruppyrup.threads.semaphores;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SemaphoreTest {

  static Map<Integer, ResourceUnit> store = new ConcurrentHashMap<>();

  static void updateResourceUnit(int id) {



      ResourceUnit ru = store.computeIfAbsent(id, ResourceUnit::new);

      synchronized (ru) {

        if (ru.isFinished()) {
          return;
        }

        ru.incrementCounter();
      }


  }

  public static void main(String[] args) {

    ExecutorService executorService = Executors.newFixedThreadPool(8);
    List<Future<String>> futures = new ArrayList<>();

    long startTime = System.currentTimeMillis();

    // creates 4 callables to be executed
    for (int i = 0; i < 100; i++) {
      RUCall callable = new RUCall();
      Future<String> future = executorService.submit(callable);
      futures.add(future);
    }
    // getting tasks results
    futures.forEach(f -> {
      try {
        System.out.println(f.get());
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    });

    long endTime = System.currentTimeMillis();

    long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.

    executorService.shutdown(); // shuts down the executor service

    long count = store.entrySet().stream()
        .filter(e -> e.getValue().isFinished())
        .count();

    System.out.println("Completed = " + count + " for time " + duration + "[mSec]");
  }


}

class RUCall implements Callable<String> {

  @Override
  public String call() throws Exception {
    for (int i = 0; i < 100; i++) {
//      Thread.sleep((long) (Math.random() * 10));
//      System.out.println("Updating ru with id :: " + i);
      SemaphoreTest.updateResourceUnit(i);
    }
    return Thread.currentThread().getName() + " completed";
  }
}
