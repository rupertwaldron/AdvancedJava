package com.ruppyrup.threads.futures;

import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.lang.Math.random;

public class Shop {
    private String name;
    private static int processors = Runtime.getRuntime().availableProcessors();
    private static Executor executor = Executors.newFixedThreadPool(Math.min(9, 100),
            (Runnable r) -> {
                Thread t = new Thread(r);
                t.setDaemon(true);
                return t;
            });

    Random random = new Random();

    public Shop(String name) {
        this.name = name;
    }

    public double getPrice(String product) {
        return calculatePrice(product);
    }

    private double calculatePrice(String product) {
        delay(1);
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }


    public static void randomDelay(long delay) {
        try {
            TimeUnit.SECONDS.sleep((long) (random() * delay));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void delay(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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

    // completable future version of method above which includes error handling
    public Future<Double> getPriceAsyncCF(String product) {
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }

    public static List<String> findPrices(List<Shop> shops, String product) {
        return shops.stream()
                .map(shop -> String.format("%s price is %.2f", shop.name, shop.getPrice(product)))
                .collect(Collectors.toList());
    }

    public static List<String> findPricesStream(List<Shop> shops, String product) {
        ForkJoinPool threadPool = new ForkJoinPool(processors);
        return threadPool.submit(() -> shops.parallelStream()
                .map(shop -> String.format("%s price is %.2f", shop.name, shop.getPrice(product)))
                .collect(Collectors.toList())).join();
    }

    public static List<String> findPricesAsync(List<Shop> shops, String product) {
        List<CompletableFuture<String>> priceFutures = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> String.format("%s price is %.2f", shop.name, shop.getPrice(product)), executor))
                .collect(Collectors.toList());
        return priceFutures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Shop shop = new Shop("Sports Direct");

        List<String> products = Arrays.asList("football", "trainers", "shorts", "astros", "studs", "bumbag");

        System.out.println("*****************Normal processing******************");

        Instant start = Instant.now();

//        products.parallelStream()
//                .map(shop::getPrice)
//                .peek(System.out::println)
//                .collect(Collectors.toList());

        for (String product : products) {
            double price = shop.getPrice(product);
            System.out.println(product + " = " + price);
        }

        getTimeDuration(start);

        System.out.println("*****************Async method processing******************");
        start = Instant.now();

        //Future<Double> trainerPrice = shop.getPriceAsync("trainers");

//        products.stream()
//                .map(shop::getPriceAsync)
//                .map(safeGet())
//                .peek(System.out::println)
//                .collect(Collectors.toList());

        Map<String, Future<Double>> futures = new HashMap<>();
        for (String product : products) {
            futures.put(product, shop.getPriceAsyncCF(product));
        }

        futures.forEach((product, future) -> {
            try {
                System.out.println(product + " = " + future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });

        getTimeDuration(start);

        // Processing with multiple Shops
        System.out.println("*****************Shop processing normal******************");
        System.out.println("Available processords = " + processors);

        List<Shop> shops = Arrays.asList(new Shop("Sports Direct"),
                new Shop("Amazon"),
                new Shop("John Lewis"),
                new Shop("Wiggle"),
                new Shop("Why not!"),
                new Shop("Teds Talent"),
                new Shop("Sainsburys"),
                new Shop("Mazda"),
                new Shop("Chain Reaction"),
                new Shop("Bobs Bikes"));

        start = Instant.now();
        List<String> priceInfo = findPrices(shops, "trainers");
        getTimeDuration(start);
        priceInfo.forEach(System.out::println);
        priceInfo.clear();

        System.out.println("*****************Shop processing parallel Stream******************");
        start = Instant.now();
        priceInfo = findPricesStream(shops, "trainers");
        getTimeDuration(start);
        priceInfo.forEach(System.out::println);


        System.out.println("*****************Shop processing Async******************");

        start = Instant.now();
        priceInfo = findPricesAsync(shops, "trainers");
        getTimeDuration(start);
        priceInfo.forEach(System.out::println);

    }

    public void test() {
        getTimeDuration(Instant.now());
    }

    private static void getTimeDuration(Instant start) {
        System.out.println("Time to process = " + Duration.between(start, Instant.now()).toMillis());
    }

    private static Function<CompletableFuture<String>, String> safeGet() {
        return future -> {
            try {
                return future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            return null;
        };
    }

}

