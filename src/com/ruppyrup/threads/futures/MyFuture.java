package com.ruppyrup.threads.futures;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class MyFuture {
    private int normalInteger = 1;
    private AtomicInteger atomicInteger = new AtomicInteger(1);

    private static Executor executor = Executors.newFixedThreadPool(Math.min(9, 100),
            (Runnable r) -> {
                Thread t = new Thread(r);
                t.setDaemon(true);
                return t;
            });


    public static void main(String[] args) {

        List<CompletableFuture<Integer>> futures = new ArrayList<>();

        MyFuture myFuture = new MyFuture();

        for (int i = 0; i < 10; i++) {
            futures.add(CompletableFuture.supplyAsync(myFuture::increment, executor));
        }

        Integer integer = futures.stream()
//                .map(future -> future.thenApply(i -> i * 2))
                .map(CompletableFuture::join)
                .reduce(0, Integer::sum);

        System.out.println(integer);

        futures.clear();

        for (int i = 0; i < 10; i++) {
            futures.add(CompletableFuture.supplyAsync(myFuture::atomicIncrement, executor));
        }

        Integer integerA = futures.stream()
//                .map(future -> future.thenApply(i -> i * 2))
                .map(CompletableFuture::join)
                .reduce(0, Integer::sum);

        System.out.println(integerA);


    }


    public synchronized int increment() {
        System.out.println("Incrementing with thread ::" + Thread.currentThread().getName() + " with int " + normalInteger);
        normalInteger = normalInteger + 1;
        try {
            Thread.sleep(100);

        } catch (InterruptedException ie) {

        }
        normalInteger = normalInteger - 1;
        System.out.println("Incrementing with thread ::" + Thread.currentThread().getName() + " with int " + normalInteger);
        return normalInteger;
    }


    public synchronized int atomicIncrement() {
        System.out.println("Incrementing with thread start ::" + Thread.currentThread().getName() + " with int " + atomicInteger);
        atomicInteger.incrementAndGet();
        try {
            Thread.sleep(100);

        } catch (InterruptedException ie) {

        }
        atomicInteger.decrementAndGet();
        System.out.println("Incrementing with thread end ::" + Thread.currentThread().getName() + " with int " + atomicInteger);
        return atomicInteger.get();
    }
}
