package com.ruppyrup.completeablefutures;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.function.Supplier;

public class ShopTest3 {

    List<Shop> shops = List.of(new Shop("BestShop"),
            new Shop("LetsSaveBig"),
            new Shop("MyFavouriteShop"),
            new Shop("Argos"),
            new Shop("BetFair"),
            new Shop("ChemistDirect"),
            new Shop("Pond Shop"),
            new Shop("DedDog"),
            new Shop("BuyItAll"));

    private static final Executor executor = Executors.newFixedThreadPool(100,
            (Runnable r) -> {
                Thread t = new Thread(r);
                t.setDaemon(true);
                return t;
            });

    public static void main(String[] args) {

//        CompletableFuture<Double> shoes = CompletableFuture.supplyAsync(() -> shop.getPrice("New shoes"), executor);
//
//
//        Double shoePrice = shoes.join();
//
//        System.out.printf("Shoe price = £%.2f%n", shoePrice);

        ShopTest3 shopListTest = new ShopTest3();

        long start = System.nanoTime();

        System.out.println(shopListTest.findPrices("myPhone247s"));

        long retrievalTime = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Price returned after " + retrievalTime + " mSecs");

        start = System.nanoTime();

        System.out.println(shopListTest.findPricesAsync("myPhone247s"));

        retrievalTime = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Price returned after " + retrievalTime + " mSecs");

        CompletableFuture<Double> sandles = runAsync(shopListTest.shops.get(0)::getPrice, "sandles", executor);
        CompletableFuture<Double> pants = runAsync(shopListTest.shops.get(1)::getPrice, "pants", executor);



        System.out.println("On its own sandles :: " + sandles.join());
        System.out.println("On its own pants :: " + pants.join());

    }

    public List<String> findPrices(String product) {
        return shops.parallelStream()
                .map(shop -> String.format("price is %.2f", shop.getPrice(product)))
                .toList();
    }

    public List<String> findPricesAsync(String product) {
        List<CompletableFuture<Double>> futureList = shops.stream()
                .map(shop -> runAsync(shop::getPrice, product, executor))
                .toList();

        return futureList.stream()
                .map(future -> future.thenApply(f -> "Price is £" + f))
                .map(CompletableFuture::join)
                .toList();
    }

    public static <R, T> CompletableFuture<R> runAsync(Function<T, R> method, T arg, Executor executor) {
        Supplier<R> supplier = () -> method.apply(arg);
        return CompletableFuture.supplyAsync(supplier, executor);
    }

    public static <R, T> CompletableFuture<Void> runAsync2(Function<T, R> method, T arg, Executor executor) {
        Runnable runnable = () -> method.apply(arg);
        return CompletableFuture.runAsync(runnable, executor);
    }

    public static <R> R runAsync(Supplier<R> supplier, Executor executor) {
        return CompletableFuture.supplyAsync(supplier, executor).join();
    }
}
