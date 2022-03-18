package com.ruppyrup.pubsub;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.concurrent.CompletableFuture.runAsync;

public class TestPubSub {

    private static final Executor executor = Executors.newFixedThreadPool(200,
            (Runnable r) -> {
                Thread t = new Thread(r);
                t.setDaemon(true);
                return t;
            });

    public static void main(String[] args) {
        Broker broker = Broker.getInstance();
        Subscriber counterMeaures = new CounterMeasures();
        Subscriber warningDisplay = new WarningDisplay();

        Publisher radar = new Radar();
        Publisher missileDetect = new MissileDetect();

        broker.register(radar.getClass(), counterMeaures);
        broker.register(missileDetect.getClass(), warningDisplay);

        List<CompletableFuture<Void>> jetFutures = IntStream.range(0, 100)
                .mapToObj(i -> runAsync(() -> radar.publish("low flying jets " + i , broker), executor))
                .toList();

        List<CompletableFuture<Void>> missileFutures = IntStream.range(0, 100)
                .mapToObj(i -> runAsync(() -> missileDetect.publish("missile detected " + i, broker), executor))
                .toList();

        Stream.concat(jetFutures.stream(), missileFutures.stream()).forEach(CompletableFuture::join);

//        jetFutures.forEach(CompletableFuture::join);
//        missileFutures.forEach(CompletableFuture::join);

    }
}
