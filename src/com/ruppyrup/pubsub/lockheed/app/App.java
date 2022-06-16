package com.ruppyrup.pubsub.lockheed.app;

import com.ruppyrup.pubsub.lockheed.core.LambdaNotifier;
import com.ruppyrup.pubsub.lockheed.core.Notifier;
import com.ruppyrup.pubsub.lockheed.plugins.Alert;
import com.ruppyrup.pubsub.lockheed.plugins.Display;
import com.ruppyrup.pubsub.lockheed.plugins.Radar;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

public class App {

  public static void main(String[] args) {
//    Notifier notifier = new StandardNotifier();
    Notifier notifier = new LambdaNotifier();
    Radar radar = new Radar(UUID.randomUUID());
    Display display = new Display(UUID.randomUUID());
    Alert alert = new Alert(UUID.randomUUID());

    radar.setNotifier(notifier);
    display.setNotifier(notifier);
    alert.setNotifier(notifier);

    radar.start();
    display.start();
    alert.start();

    int threadCount = 1000;
    ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
    final CountDownLatch readyThreadCounter = new CountDownLatch(threadCount);
    final CountDownLatch callingThreadBlocker = new CountDownLatch(1);
    final CountDownLatch completedThreadCounter = new CountDownLatch(threadCount);

    List<CompletableFuture<Void>> completableFutures = Stream.generate(
            () -> CompletableFuture.runAsync(() -> {
              readyThreadCounter.countDown();
              try {
                callingThreadBlocker.await();
              } catch (InterruptedException e) {
                throw new RuntimeException(e);
              }
              radar.addPlane();
            }, executorService))
        .limit(threadCount)
        .toList();

    callingThreadBlocker.countDown();

    completedThreadCounter.countDown();

    completableFutures.forEach(CompletableFuture::join);

    executorService.shutdown();

    radar.shutdown();
    display.shutdown();
    alert.shutdown();

  }

}
