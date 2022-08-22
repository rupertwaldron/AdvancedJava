package com.ruppyrup.patterns.decorator;

public class FictionBookDecorator extends BookDecorator {

    public FictionBookDecorator(Book book) {
        super(book);
    }

    @Override
    public String describe() {
        return "Fiction " + book.describe();
    }
}
