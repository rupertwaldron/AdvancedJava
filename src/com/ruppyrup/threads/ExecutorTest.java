package com.ruppyrup.threads;

import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class ExecutorTest {
    public static void main(String[] args) {
        var cachedThreadPool = Executors.newCachedThreadPool(); // creates new threads as needed
        var fixedThreadPool = Executors.newFixedThreadPool(4); // fixed pool of threads

        IntStream.rangeClosed(1, 4).forEach(i -> {
            cachedThreadPool.execute(new TaskRunn());
            fixedThreadPool.execute(new TaskRunn());
        });

        cachedThreadPool.shutdown();
        fixedThreadPool.shutdown();
    }
}


class TaskRunn implements Runnable {
    @Override
    public void run() {
        System.out.println("I am " +
            Thread.currentThread().getName());
    }
}