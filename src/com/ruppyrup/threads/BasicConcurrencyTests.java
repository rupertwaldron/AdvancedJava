package com.ruppyrup.threads;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class BasicConcurrencyTests {
    public static void main(String[] args)
        throws InterruptedException {
        // pool of 4 threads
        ExecutorService executorService =
            Executors.newFixedThreadPool(4);

        // creates 3 callables to be executed
        List<Callable<String>> callables = Arrays.asList(
            new TaskCall(), new TaskCall(), new TaskCall());

        List<Future<String>> futures =
            executorService.invokeAll(callables); // sends list of callables to be executed asynchronously

        // getting tasks results
        futures.forEach(f -> {
            try {
                System.out.println(f.get());
            } catch (Exception e) {
            }
        });
        executorService.shutdown(); // shuts down the executor service
    }
}
