package com.ruppyrup.patterns.iterators.unclebob;

import java.util.Iterator;

/**
 * Returns an infinit list of integers
 */
public class Integers implements Iterable<Integer>{
  @Override
  public Iterator<Integer> iterator() {
    return new Iterator<>() {
      private int i = 1;

      @Override
      public boolean hasNext() {
        return true;
      }

      @Override
      public Integer next() {
        return i++;
      }
    };
  }
    public static Iterator<Integer> all() {
      return new Integers().iterator();
    }
}
