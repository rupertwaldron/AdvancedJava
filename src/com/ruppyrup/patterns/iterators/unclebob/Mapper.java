package com.ruppyrup.patterns.iterators.unclebob;

import java.util.Iterator;
import java.util.function.UnaryOperator;

public class Mapper<T> {
  public Iterator<T> map(UnaryOperator<T> function, Iterator<T> iterator) {
    return new Iterator<>() {
      @Override
      public boolean hasNext() {
        return iterator.hasNext();
      }

      @Override
      public T next() {
        return function.apply(iterator.next());
      }
    };
  }
}
