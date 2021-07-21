package com.ruppyrup.threads;

public class Counter2 {

    int count;

    volatile boolean canChange = true;

    public void increment() { // ensure thread safety
        if (canChange) {
            canChange = false;
            count++; // count = count + 1
            canChange = true;
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Counter2 counter = new Counter2();

        Thread c1 = new Thread(() -> {
            for (int i = 0; i < 500; i++) {
                counter.increment();
            }
        });
        Thread c2 = new Thread(() -> {
            for (int i = 0; i < 500; i++) {
                counter.increment();
            }
        });
        c1.start(); // async counter thread 1 start
        c2.start(); // async counter thread 1 start
        // awating async threads to finish
        c1.join();
        c2.join();
        System.out.println(counter.count);
    }
}
