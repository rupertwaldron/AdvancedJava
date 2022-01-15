package com.ruppyrup.completeablefutures;

import java.util.concurrent.Future;

public class ShopTest {
    public static void main(String[] args) {
        Shop shop = new Shop("BestShop");
        long start = System.nanoTime();
        Future<Double> futurePrice = shop.getPriceAsync("tin of beans");

        long invocationTime = (System.nanoTime() - start) / 1_000_000;

        System.out.println("Invocation returned after " + invocationTime + " mSecs");

        for (int i = 0; i < 5; i++) {
            Shop.delay(500);
            System.out.println("Doing something " + i + " times");
        }

        try {
            double price = futurePrice.get();
            System.out.printf("Price is %.2f%n", price);

        } catch (Exception e) {
            e.printStackTrace();
        }

        long retrievalTime = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Price returned after " + retrievalTime + " mSecs");
    }
}
