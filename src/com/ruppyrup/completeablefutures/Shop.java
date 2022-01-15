package com.ruppyrup.completeablefutures;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class Shop {

    private final String name;

    Random random = new Random();

    public Shop(String shopName) {
        this.name = shopName;
    }

    public double getPrice(String product) {
        return calculatePrice(product);
    }

    public static void delay(long delayTime) {
        try {
            Thread.sleep(delayTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String getName() {
        return name;
    }

    private double calculatePrice(String product) {
        delay(1000);
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }


    public Future<Double> getPriceAsync(String product) {
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();

        new Thread(() -> {
            try {
                double price = calculatePrice(product);
                futurePrice.complete(price);
            } catch (Exception ex) {
                futurePrice.completeExceptionally(ex);
            }
        }).start();

        return futurePrice;
    }

    public Future<Double> getPriceAsync2(String produce) {
        return CompletableFuture.supplyAsync(() -> calculatePrice(produce));
    }
}
