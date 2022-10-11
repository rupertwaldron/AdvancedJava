package com.ruppyrup.patterns.iterators.unclebob;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Taker<T> {
  public List<T> take(int n, Iterator<T> xs) {
    List<T> taken = new ArrayList<>();
    for (int i = 0; xs.hasNext() && i < n; i++) {
      taken.add(xs.next()); // this is the loop!!
    }
    return taken;
  }
}
