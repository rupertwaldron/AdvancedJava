package com.ruppyrup.countdownlatch;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

public class RRCountDown {
  static int rrCounter = 0;
  private final CountDownLatch readyThreadCounter;
  private final CountDownLatch callingThreadBlocker;
  private final CountDownLatch completedThreadCounter;

  public RRCountDown(final CountDownLatch readyThreadCounter,
      final CountDownLatch callingThreadBlocker, final CountDownLatch completedThreadCounter) {
    this.readyThreadCounter = readyThreadCounter;
    this.callingThreadBlocker = callingThreadBlocker;
    this.completedThreadCounter = completedThreadCounter;
  }

  public void run() {
    try {

//      Thread.sleep((int) (Math.random() * 1000));
      readyThreadCounter.countDown();
      callingThreadBlocker.await();
      System.out.println("Started ... " + Thread.currentThread().getName());
      printName();
      updateCounter();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      completedThreadCounter.countDown();
    }
  }

  public void printName() {
    System.out.println("Name of thread" + Thread.currentThread().getName());
    Connection.INSTANCE.incrementCounter();
  }

  public static void updateCounter() {
    int temp = rrCounter;
    rrCounter = temp + 1;
  }

  public static void main(String[] args) throws InterruptedException {
    int threadCount = 1000;
    ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
    final CountDownLatch readyThreadCounter = new CountDownLatch(threadCount);
    final CountDownLatch callingThreadBlocker = new CountDownLatch(1);
    final CountDownLatch completedThreadCounter = new CountDownLatch(threadCount);

    List<CompletableFuture<Void>> completableFutures = Stream.generate(
            () -> CompletableFuture.runAsync(
                () -> new RRCountDown(readyThreadCounter, callingThreadBlocker,
                    completedThreadCounter).run(), executorService))
        .limit(threadCount)
        .toList();

    // Wait for threads
    readyThreadCounter.await();
    System.out.println("Runnables ready");
    callingThreadBlocker.countDown();
    completedThreadCounter.await();
    completableFutures.forEach(CompletableFuture::join);

    System.out.println("Result = " + Connection.INSTANCE.getCounter());
    System.out.println("RR Counter = " + rrCounter);
    executorService.shutdown();
  }
}
