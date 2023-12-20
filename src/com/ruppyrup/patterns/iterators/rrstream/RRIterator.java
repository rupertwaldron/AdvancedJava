package com.ruppyrup.patterns.iterators.rrstream;

public interface RRIterator<T> {
    boolean hasNext();

    T next();
}
