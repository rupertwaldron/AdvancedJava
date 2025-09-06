package com.ruppyrup.threads.othermain;

import java.util.concurrent.Executors;

public class MainTwo {
    public static void main(String[] args) throws InterruptedException {
        var cachedThreadPool = Executors.newCachedThreadPool();
        String[] myarray = new String("Hello Rupert this is great").split(" ");
        Runnable runable = () -> MainOne.main(myarray);
        cachedThreadPool.execute(runable);
        Thread.sleep(1000);
        System.out.println("Hello from MainTwo");
        cachedThreadPool.shutdown();
    }
}
