package com.ruppyrup.countdownlatch.udemycourse;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SimpleCountDownLatch {
    private int count;

    private Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    public SimpleCountDownLatch(int count) {
        this.count = count;
        if (count < 0) {
            throw new IllegalArgumentException("count cannot be negative");
        }
    }

    /**
     * Causes the current thread to wait until the latch has counted down to zero.
     * If the current count is already zero then this method returns immediately.
     */
    public void await() throws InterruptedException {
        lock.lock();
        try {
            while (count > 0) {
                System.out.println("Thread is blocked");
                condition.await(); // thread goes to sleep and lock is released.
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupt exception");
        } finally {
            System.out.println("Lock released");
            lock.unlock();
        }
    }

    /**
     * Decrements the count of the latch, releasing all waiting threads when the count reaches zero.
     * If the current count already equals zero then nothing happens.
     */
    public void countDown() {
        lock.lock();
        if (count > 0) {
            count--;
            if (count == 0) {
                condition.signalAll();
            }

        }
        lock.unlock();
    }

    /**
     * Returns the current count.
     */
    public int getCount() {
        return count;
    }

    public static void main(String[] args) {
        SimpleCountDownLatch latch = new SimpleCountDownLatch(4);

        Runnable printme = () -> {
            latch.countDown();
            safeAwait(latch);
            System.out.println(Thread.currentThread() + " says hello");
        };

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            threads.add(new Thread(printme));
        }

        threads.forEach(Thread::start);

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Count = " + latch.getCount());

    }

    public static void safeAwait(SimpleCountDownLatch latch) {
        try {
            latch.await();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
