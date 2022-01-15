package com.ruppyrup.threads;

public class Counter {

    int count;

    public synchronized void increment() { // ensure thread safety
        count++; // count = count + 1
    }

    public void nonSafeIncrement(int a) { // ensure thread safety
       count = count + a;
    }


    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread c1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                counter.nonSafeIncrement(i);
            }
        });
        Thread c2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                counter.nonSafeIncrement(i);
            }
        });
        Thread c3 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                counter.nonSafeIncrement(i);
            }
        });
        Thread c4 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                counter.nonSafeIncrement(i);
            }
        });
        c1.start(); // async counter thread 1 start
        c2.start(); // async counter thread 1 start
        c3.start(); // async counter thread 1 start
        c4.start(); // async counter thread 1 start
        // awating async threads to finish
        c1.join();
        c2.join();
        c3.join();
        c4.join();
        System.out.println(counter.count);
    }
}
