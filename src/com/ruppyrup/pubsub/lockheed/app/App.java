package com.ruppyrup.pubsub.lockheed.app;

import com.ruppyrup.pubsub.lockheed.core.LambdaNotifier;
import com.ruppyrup.pubsub.lockheed.core.Notifier;
import com.ruppyrup.pubsub.lockheed.plugins.Alert;
import com.ruppyrup.pubsub.lockheed.plugins.Display;
import com.ruppyrup.pubsub.lockheed.plugins.Radar;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
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

    List<CompletableFuture<Void>> completableFutures = Stream.generate(
            () -> CompletableFuture.runAsync(radar::addPlane))
        .limit(10)
        .toList();

    completableFutures.forEach(CompletableFuture::join);

    radar.shutdown();
    display.shutdown();
    alert.shutdown();

  }

}
