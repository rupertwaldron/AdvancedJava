package com.ruppyrup.threads.semaphores;

import lombok.SneakyThrows;

import java.util.*;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {

  static Deque<ResourceUnit> store = new LinkedList<>();

  static Semaphore full = new Semaphore(0); // this will block the consumer until there is a resource in the list
  static Semaphore empty = new Semaphore(1); // this unblocks the producer to add more resource

  static final int NO_OF_THREADS = 4;
  static final int NO_OF_EVENTS = 10;

  static int count;

  public static void main(String[] args) {
    List<Thread> threads = new ArrayList<>();

    Thread quitter = new Thread(() -> {
      Scanner scanner = new Scanner(System.in);
      String next = scanner.next();
      if ("quit".equals(next)) System.exit(0);
    });

    quitter.setDaemon(true);
    quitter.start();

    // creates 4 callables to be executed
    for (int i = 0; i < NO_OF_THREADS; i++) {
      RUProducer ruProducer = new RUProducer();
      Thread producerThread = new Thread(ruProducer);
      threads.add(producerThread);
    }

    for (int i = 0; i < NO_OF_THREADS; i++) {
      RUConsumer ruConsumer = new RUConsumer();
      Thread consumerThread = new Thread(ruConsumer);
      threads.add(consumerThread);
    }


    long startTime = System.currentTimeMillis();
    // getting tasks results
    threads.forEach(Thread::start);

    threads.forEach(t -> {
      try {
        t.join(2000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    });

    long endTime = System.currentTimeMillis();

    long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.

    System.out.println("Count = " + count + " Deque contains = " + store.size() + " for time " + duration + "[mSec]");
  }

  static void addResourceUnit(int id) {
    ResourceUnit resourceUnit = new ResourceUnit(id);
    store.offer(resourceUnit);
    System.out.println("Added RU = " + resourceUnit);
  }

  public static void removeResourceUnit() {
    if (store.isEmpty()) return;
    ResourceUnit resourceUnit = store.removeLast();
    count++;
    System.out.println("Removed RU = " + resourceUnit);
  }
}

class RUProducer implements Runnable {
  @SneakyThrows
  @Override
  public void run() {
    for (int i = 0; i < SemaphoreTest.NO_OF_EVENTS; i++) {
      SemaphoreTest.empty.acquire();
      System.out.println("Producer " + Thread.currentThread().getName() + " has aquired the empty lock");
      SemaphoreTest.addResourceUnit(i);
      SemaphoreTest.full.release();
      System.out.println("Producer " + Thread.currentThread().getName() + " has released the full lock");
    }
  }
}

class RUConsumer implements Runnable {
  @SneakyThrows
  @Override
  public void run() {
    while (true) {
      SemaphoreTest.full.acquire();
      System.out.println("Current count = " + SemaphoreTest.count + " with consumer thread = " + Thread.currentThread().getName() + " has aquired the full lock");
      SemaphoreTest.removeResourceUnit();
      SemaphoreTest.empty.release();
      System.out.println("Consumer " + Thread.currentThread().getName() + " has released the empty lock");
    }
  }
}
