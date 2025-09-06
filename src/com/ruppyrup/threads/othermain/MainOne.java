package com.ruppyrup.threads.othermain;

public class MainOne {

    public static void main(String[] args) {
        System.out.println("Hello World");
        for (int i = 0; i < args.length; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(args[i]);
        }
    }
}
