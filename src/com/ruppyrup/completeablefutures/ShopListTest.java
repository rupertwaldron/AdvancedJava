package com.ruppyrup.completeablefutures;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ShopListTest {

    List<Shop> shops = List.of(new Shop("BestShop"),
            new Shop("LetsSaveBig"),
            new Shop("MyFavouriteShop"),
            new Shop("Argos"),
            new Shop("BetFair"),
            new Shop("ChemistDirect"),
            new Shop("Pond Shop"),
            new Shop("DedDog"),
            new Shop("BuyItAll"));

    private final Executor executor = Executors.newFixedThreadPool(Math.min(shops.size(), 100),
            (Runnable r) -> {
                Thread t = new Thread(r);
                t.setDaemon(true);
                return t;
            });

    public static void main(String[] args) {

        ShopListTest shopListTest = new ShopListTest();

        long start = System.nanoTime();

        System.out.println(shopListTest.findPrices("myPhone247s"));

        long retrievalTime = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Price returned after " + retrievalTime + " mSecs");

        start = System.nanoTime();

        System.out.println(shopListTest.findPricesAsync("myPhone247s"));

        retrievalTime = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Price returned after " + retrievalTime + " mSecs");
    }

    public List<String> findPrices(String product) {
        return shops.parallelStream()
                .map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)))
                .toList();
    }

    public List<String> findPricesAsync(String product) {
        List<CompletableFuture<String>> priceFutures = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(
                        () -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)), executor))
                .toList();

        return priceFutures.stream()
                .map(future -> future.thenApply(f -> f + " in d shop!"))
                .map(CompletableFuture::join)
                .toList();
    }
}
