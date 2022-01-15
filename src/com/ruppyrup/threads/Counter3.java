package com.ruppyrup.threads;

public class Counter3 {

    int count;

    volatile boolean canChange = true;

    public void increment() { // ensure thread safety
        if (canChange) {
            canChange = false;
            count++; // count = count + 1
            canChange = true;
        }
    }

    public Postman gotState(String name) throws InterruptedException {
        count++;
        String namelocal = name;

        Thread.sleep(1000);
        System.out.println("1st gotState with thread :: " + Thread.currentThread().getName() + " -> " + name);

        Postman postie = new Postman(name, count);

        Thread.sleep(1000);

        System.out.println("2nd gotState with thread :: " + Thread.currentThread().getName() + " -> " + name);

        return postie;
    }


    public static void main(String[] args) throws InterruptedException {
        Counter3 counter = new Counter3();

        Thread c1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                Postman bob1 = null;
                try {
                    bob1 = counter.gotState("Bob1");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(bob1);
            }
        });
        Thread c2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                Postman fred2 = null;
                try {
                    fred2 = counter.gotState("Fred2");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(fred2);
            }
        });
        c1.start(); // async counter thread 1 start
        c2.start(); // async counter thread 1 start
        // awating async threads to finish
        c1.join();
        c2.join();
        System.out.println(counter.count);
    }

    class Postman {
        String name;
        int age;

        public Postman(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Postman{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
