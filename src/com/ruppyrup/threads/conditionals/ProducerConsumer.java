package com.ruppyrup.threads.conditionals;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumer {
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private String username = null, password = null;

    public void validateUser() {
            lock.lock();
            try {
                while(username == null || password == null) {
                    System.out.println("Blocked as username and/or password are null");
                    condition.await(); // lock associated with this thread is released and thread is put to sleep
                    // waits for condition.signal() and the lock to be released.
                }
            } catch (InterruptedException ie) {
                // do nothing
            }
            finally {
                lock.unlock();
            }
        System.out.println("Now we can get on with other stuff");
    }

    public void getUser() {
        lock.lock(); // can only acquire this if unlocked by other thread
        try(var scanner = new Scanner(System.in)) {
            System.out.print("Enter username :: ");
            username = scanner.nextLine();
            System.out.print("\nEnter password :: ");
            password = scanner.nextLine();
            condition.signal(); // wakes up the validation thread so it can check the condition
        } finally {
            lock.unlock(); // validation thread has to wait until the lock is released
        }
    }
    public static void main(String[] args) {
        ProducerConsumer pc = new ProducerConsumer();
        Thread validatorThread = new Thread(pc::validateUser);
        Thread uiThread = new Thread(pc::getUser);
        validatorThread.start();
        uiThread.start();
    }
}
