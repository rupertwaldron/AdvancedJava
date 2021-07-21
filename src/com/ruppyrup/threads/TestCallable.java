package com.ruppyrup.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestCallable { // use callable when you need a returned value

    public static void main(String[] args) {
        // pool of 4 threads
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        List<Future<String>> futures = new ArrayList<>();


        // creates 4 callables to be executed
        for (int i = 0; i < 4; i++) {
            TaskCall callable = new TaskCall();
            Future<String> future = executorService.submit(callable);
            futures.add(future);
        }
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




class TaskCall implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "I am " + Thread.currentThread().getName();
    }
}