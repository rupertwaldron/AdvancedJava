package com.ruppyrup.threads.futures;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AnyofTest {

    private static final int cores = Runtime.getRuntime().availableProcessors();

    private ExecutorService executor;

    public static void main(String[] args) {
        AnyofTest test = new AnyofTest();
        int i = test.processThreads();
        System.out.println("First result = " + i);


        AnyofTest test2 = new AnyofTest();
        int i1 = test2.processThreads();
        System.out.println("Second result = " + i1);

    }

    private int processThreads() {
        executor = startExecutors();
        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(() -> getNumber(1000, 10), executor);
        CompletableFuture<Integer> cf2 = CompletableFuture.supplyAsync(() -> getNumber(500, 30), executor);

        Object join = CompletableFuture.anyOf(cf1, cf2).whenComplete((res, th) -> {
            System.out.println(Thread.currentThread().getName() + " has completed with result => " + res);
        }).join();


//        executor.shutdownNow();

        return (int)join;
    }

    private ExecutorService startExecutors() {
        return executor = Executors.newFixedThreadPool(cores,
                (Runnable r) -> {
                    Thread t = new Thread(r);
                    t.setDaemon(true);
                    return t;
                });
    }

    private int getNumber(int wait, int num) {
        int count = 0;
        for (int i = 0; i < num; i++) {
            try {
                Thread.sleep(wait);
            } catch (InterruptedException e) {
                return count;
            }
            System.out.println(Thread.currentThread().getName() + " count is => " + count++);
        }
        return count;
    }
}
