package com.ruppyrup.patterns.iterators.rrstream;

public class Integers implements RRIterator<Integer> {
    private int value;
    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Integer next() {
        System.out.println("Sending next value -> " + value);
        return value++;
    }
}
