package com.ruppyrup.pubsub.lambda.utils;

import java.util.concurrent.locks.Lock;
import java.util.function.Supplier;

public class UtilLock {

  public static void lock(final Lock lock, final Runnable runnable) {
    try {
      lock.lock();
      runnable.run();
    } finally {
      lock.unlock();
    }
  }


  public  static <T> T lock(final Lock lock, final Supplier<T> supplier) {
    final T result;
    try {
      lock.lock();
      result = supplier.get();
    } finally {
      lock.unlock();
    }
    return result;
  }
}
