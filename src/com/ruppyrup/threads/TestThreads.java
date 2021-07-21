package com.ruppyrup.threads;

import java.util.Random;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class TestThreads {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Start of main thread");
        Thread ping = new Ping();
        Thread pong = new Pong();
        ping.start(); // if use the run method all the work is done squentially, so need to use start()
        pong.start();
        Thread bong = new Thread(new Bong());
            bong.start(); // runnable interface means can extend another class
        Thread bing = new Thread(() -> IntStream.rangeClosed(1, 3)
            .forEach(i -> {
                new TestThreads().happySleep(4000);
                System.out.println("bing");
            }));
        bing.start();

        ping.join(); // Main thread will wait until these have completed.
        pong.join();
        bong.join();
        bing.join();
        System.out.println("End of main thread");
    }

    private Consumer<Integer> happySleep(int time) {
        return i -> {
            try {
                Thread.sleep(new Random().nextInt(time));
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
    }
}




class Ping extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            // simulates work that takes between from 0 to 4 sec
            try {
                Thread.sleep(new Random().nextInt(4000));
            }
            catch (InterruptedException e) {

            }

            System.out.println("ping");
        }
    }
}
class Pong extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            // simulates work that takes between from 0 to 4 sec
            try {
                Thread.sleep(new Random().nextInt(4000));
            } catch (InterruptedException e) {

            }

            System.out.println("pong");
        }
    }
}

class Bong implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            // simulates work that takes between from 0 to 4 sec
            try {
                Thread.sleep(new Random().nextInt(4000));
            } catch (InterruptedException e) {

            }

            System.out.println("bong");
        }
    }
}