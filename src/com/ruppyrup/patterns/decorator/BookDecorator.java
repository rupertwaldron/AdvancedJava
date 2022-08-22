package com.ruppyrup.patterns.decorator;

public class BookDecorator implements Book {
    protected Book book;

    public BookDecorator(Book book) {
        this.book = book;
    }

    @Override
    public String describe() {
        return book.describe();
    }
}
